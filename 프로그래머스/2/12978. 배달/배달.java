import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    static int INF = 50_000_000;
    static List<Node>[] map;
    static int[] minDistance;
    static boolean[] isVisited;

    private static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int end, int weight) {
            this.vertex = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node that) {
            return this.weight - that.weight;
        }
    }

    public int solution(int N, int[][] road, int K) {
        minDistance = new int[N+1];
        Arrays.fill(minDistance, INF);

        isVisited = new boolean[N+1];
        map = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] info : road) {
            int start = info[0];
            int end = info[1];
            int weight = info[2];
            
            map[start].add(new Node(end, weight));
            map[end].add(new Node(start, weight));
        }
        
        calcMinDistanceFrom(1);
        
        int answer = 0;
        for (int distance : minDistance) {
            if (distance <= K) {
                answer += 1;
            }
        }
        return answer;
    }

    private void calcMinDistanceFrom(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        minDistance[start] = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (isVisited[current.vertex]) continue;
            isVisited[current.vertex] = true;

            for (Node next : map[current.vertex]) {
                int nextWeight = minDistance[current.vertex] + next.weight;
                if (nextWeight < minDistance[next.vertex]) {
                    minDistance[next.vertex] = nextWeight;
                    queue.add(new Node(next.vertex, nextWeight));
                }
            }
        }
    }
}
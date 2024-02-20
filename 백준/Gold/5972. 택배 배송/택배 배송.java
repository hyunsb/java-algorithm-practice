import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static long INF = 2_500_000_000L;
    static int n, m;
    static List<Node>[] map;
    static long[] minDistance;
    static boolean[] isVisited;

    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node that) {
            return this.weight - that.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        map = new ArrayList[n+1];
        minDistance = new long[n+1];
        isVisited = new boolean[n+1];

        Arrays.fill(minDistance, INF);
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Node(end, weight));
            map[end].add(new Node(start, weight));
        }

        System.out.println(findMinimumRoute(1, n));
    }

    private static long findMinimumRoute(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!queue.isEmpty() && !isVisited[end]) {
            Node current = queue.poll();
            if (isVisited[current.end])
                continue;

            isVisited[current.end] = true;
            for (Node next : map[current.end]) {
                int nextWeight = current.weight + next.weight;
                if (nextWeight < minDistance[next.end]) {
                    minDistance[next.end] = nextWeight;
                    queue.add(new Node(next.end, nextWeight));
                }
            }
        }

        return minDistance[end];
    }
}
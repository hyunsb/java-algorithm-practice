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

    static int INF = 1_000_000_000;
    static List<Node>[] map;
    static int[] minDistance;
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
        int repeat = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer;

        for (int i = 0; i < repeat; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            map = new ArrayList[n+1];
            minDistance = new int[n+1];
            isVisited = new boolean[n+1];
            Arrays.fill(minDistance, INF);
            for (int j = 0; j <= n; j++) {
                map[j] = new ArrayList<>();
            }

            for (int dependency = 0; dependency < d; dependency++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                map[end].add(new Node(start, weight));
            }

            dijkstra(c);
            int count = 0;
            int time = 0;
            for (int distance : minDistance) {
                if (distance == INF)
                    continue;
                count += 1;
                time = Math.max(time, distance);
            }

            System.out.println(count + " " + time);
        }
    }

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (isVisited[current.end]) continue;
            isVisited[current.end] = true;

            for (Node next : map[current.end]) {
                int nextWeight = current.weight + next.weight;
                if (minDistance[next.end] > nextWeight) {
                    minDistance[next.end] = nextWeight;
                    queue.add(new Node(next.end, nextWeight));
                }
            }
        }
    }
}
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

    private static int INF = 1_000_000_000;
    private static List<Node>[] map;
    private static boolean[] isVisited;
    private static int[] minDistance;

    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node that) {
            return this.weight - that.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        map = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        minDistance = new int[n+1];

        Arrays.fill(minDistance, INF);
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int root = Integer.parseInt(tokenizer.nextToken());
            int vertex = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[root].add(new Node(vertex, weight));
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());

        dijkstra(start, end);
        System.out.println(minDistance[end]);
    }

    private static void dijkstra(int start, int end) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.vertex;
            
            if (isVisited[currentVertex]) continue;
            isVisited[currentVertex] = true;
            if (currentVertex == end) return;

            for (Node node : map[currentVertex]) {
                int nextVertex = node.vertex;
                int nextWeight = node.weight + minDistance[currentVertex];
                if (minDistance[nextVertex] > nextWeight) {
                    minDistance[nextVertex] = nextWeight;
                    queue.add(new Node(nextVertex, nextWeight));
                }
            }
        }
    }
}
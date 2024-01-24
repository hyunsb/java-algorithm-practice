import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M, X, INF = 10_000_000;

    static List<Node>[] mapFromX;
    static int[] minDistanceFromX;

    static List<Node>[] mapToX;
    static int[] minDistanceToX;

    static boolean[] isVisited;

    static void dijkstra(int start, List<Node>[] map, int[] minDistance) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        isVisited = new boolean[N+1];
        minDistance[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.vertex;
            if (isVisited[currentVertex]) continue;

            isVisited[currentVertex] = true;
            minDistance[currentVertex] = current.weight;

            for (Node node : map[currentVertex]) {
                int nextWeight = node.weight + current.weight;
                if (nextWeight < INF) {
                    queue.add(new Node(node.vertex, nextWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
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
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        X = Integer.parseInt(tokenizer.nextToken());

        mapFromX = new ArrayList[N+1];
        minDistanceFromX = new int[N+1];
        mapToX = new ArrayList[N+1];
        minDistanceToX = new int[N+1];
        Arrays.fill(minDistanceFromX, INF);
        Arrays.fill(minDistanceToX, INF);
        for (int i = 0; i < N + 1; i++) {
            mapFromX[i] = new ArrayList<>();
            mapToX[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            mapFromX[start].add(new Node(end, weight));
            mapToX[end].add(new Node(start, weight));
        }

        dijkstra(X, mapFromX, minDistanceFromX);
        dijkstra(X, mapToX, minDistanceToX);

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) {
            int distance = minDistanceFromX[i] + minDistanceToX[i];
            if (distance > maxDistance) maxDistance = distance;
        }
        System.out.println(maxDistance);
    }
}
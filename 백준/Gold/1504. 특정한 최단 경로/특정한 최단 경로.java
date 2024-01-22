import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;

    static List<Node>[] map;
    static boolean[] isVisited;

    static int[] minDistanceFromStart;
    static int[] minDistanceFromV1;
    static int[] minDistanceFromV2;

    private static void dijkstra(int start, int[] minDistance, int ... ends) {
        Queue<Node> queue = new PriorityQueue<>();
        isVisited = new boolean[n+1];
        queue.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.vertex;

            if (isVisited[currentVertex]) continue;
            isVisited[currentVertex] = true;

            boolean isDone = true;
            for (int end : ends) {
                if (!isVisited[end]) isDone = false;
            }
            if (isDone) return;

            for (Node node : map[currentVertex]) {
                int nextVertex = node.vertex;
                int nextWeight = node.weight + minDistance[currentVertex];

                if (nextWeight < minDistance[nextVertex]) {
                    minDistance[nextVertex] = nextWeight;
                    queue.add(new Node(nextVertex, nextWeight));
                }
            }
        }
    }

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
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int INF = 2_000_000_000;

        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        map = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        minDistanceFromStart = new int[n+1];
        minDistanceFromV1 = new int[n+1];
        minDistanceFromV2 = new int[n+1];
        Arrays.fill(minDistanceFromStart, INF);
        Arrays.fill(minDistanceFromV1, INF);
        Arrays.fill(minDistanceFromV2, INF);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Node(end, weight));
            map[end].add(new Node(start, weight));
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int v1 = Integer.parseInt(tokenizer.nextToken());
        int v2 = Integer.parseInt(tokenizer.nextToken());


        dijkstra(1, minDistanceFromStart, v1, v2);
        dijkstra(v1, minDistanceFromV1, v2, n);
        dijkstra(v2, minDistanceFromV2, v1, n);

        long selectV1 = 0;
        selectV1 += minDistanceFromStart[v1];
        selectV1 += minDistanceFromV1[v2];
        selectV1 += minDistanceFromV2[n];
        
        long selectV2 = 0;
        selectV2 += minDistanceFromStart[v2];
        selectV2 += minDistanceFromV2[v1];
        selectV2 += minDistanceFromV1[n];
        
        System.out.println((selectV1 >= INF && selectV2 >= INF) ? -1 : Math.min(selectV1, selectV2));
    }
}
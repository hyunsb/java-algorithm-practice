import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Node>[] map;
    static int[] minDistance;
    static boolean[] isVisited;

    private static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(start, 0));
        minDistance[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.vertex;

            if (isVisited[currentVertex]) continue;
            isVisited[currentVertex] = true;

            for (Node node : map[currentVertex]) {
                int nextVertex = node.vertex;
                int nextWeight = node.weight + minDistance[currentVertex];

                if (nextWeight < minDistance[nextVertex]) {
                    minDistance[nextVertex] = nextWeight;
                    queue.offer(new Node(nextVertex, nextWeight));
                }
            }
        }
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(bufferedReader.readLine());
        int INF = 3_000_001;

        map = new ArrayList[n+1];
        minDistance = new int[n+1];
        isVisited = new boolean[n+1];
        
        Arrays.fill(minDistance, INF);
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int root = Integer.parseInt(tokenizer.nextToken());
            int vertex = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[root].add(new Node(vertex, weight));
        }

        dijkstra(start);
        for (int i = 1; i <= n; i++) {
            System.out.println((minDistance[i] == INF) ? "INF" : minDistance[i]);
        }
    }
}
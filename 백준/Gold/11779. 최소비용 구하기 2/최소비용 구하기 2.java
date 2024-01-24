import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Node>[] map;
    static int n, m, start, end, INF = 100_000_000;
    static int[] minDistance, preVisited;
    static boolean[] isVisited;

    private static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        minDistance[start] = 0;
        preVisited[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentVertex = current.vertex;

            if (isVisited[currentVertex]) continue;
            isVisited[currentVertex] = true;

            for (Node next : map[currentVertex]) {
                int nextVertex = next.vertex;
                int nextWeight = next.weight + minDistance[currentVertex];
                if (nextWeight < minDistance[nextVertex]) {
                    minDistance[nextVertex] = nextWeight;
                    queue.add(new Node(nextVertex, nextWeight));
                    preVisited[nextVertex] = currentVertex;
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
        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());

        map = new List[n+1];
        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Node(end, weight));
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(tokenizer.nextToken());
        end = Integer.parseInt(tokenizer.nextToken());

        isVisited = new boolean[n+1];
        preVisited = new int[n+1];
        minDistance = new int[n+1];
        Arrays.fill(minDistance, INF);
        dijkstra();

        System.out.println(minDistance[end]);

        Stack<Integer> routes = new Stack<>();
        int current = end;
        while (current != 0) {
            routes.add(current);
            current = preVisited[current];
        }
        System.out.println(routes.size());
        while (!routes.isEmpty()) {
            System.out.print(routes.pop() + " ");
        }
    }
}
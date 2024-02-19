import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int nodeNumber, edgeNumber;
    static int INF = 60_000_000;

    static List<Node>[] map;
    static long[] minDistance;

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

        nodeNumber = Integer.parseInt(tokenizer.nextToken());
        edgeNumber = Integer.parseInt(tokenizer.nextToken());

        map = new ArrayList[nodeNumber+1];
        minDistance = new long[nodeNumber+1];

        Arrays.fill(minDistance, INF);
        for (int i = 0; i < nodeNumber + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeNumber; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Node(end, weight));
        }

        // create negative cycle from map
        bellmanFord();

        if (isCreatedNegativeCycle()) {
            System.out.println(-1);
            return;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 2; i < nodeNumber + 1; i++) {
            if (minDistance[i] == INF) {
                answer.append("-1").append("\n");
                continue;
            }
            answer.append(minDistance[i]).append("\n");
        }
        System.out.println(answer);
    }

    private static void bellmanFord() {
        minDistance[1] = 0;
        for (int repeat = 1; repeat < nodeNumber; repeat++) {

            for (int current = 1; current < nodeNumber + 1; current++) {

                for (Node next : map[current]) {
                    if (minDistance[current] == INF) {
                        break;
                    }
                    
                    long nextWeight = minDistance[current] + next.weight;
                    if (nextWeight < minDistance[next.vertex]) {
                        minDistance[next.vertex] = nextWeight;
                    }
                }
            }
        }
    }

    private static boolean isCreatedNegativeCycle() {
        for (int current = 1; current < nodeNumber + 1; current++) {
            for (Node next : map[current]) {
                if (minDistance[current] == INF)
                    break;

                long nextWeight = minDistance[current] + next.weight;
                if (nextWeight < minDistance[next.vertex]) {
                    return true;
                }
            }
        }
        return false;
    }
}
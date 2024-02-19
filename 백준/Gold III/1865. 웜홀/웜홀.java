import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int nodeNumber, roadNumber, wormHoleNumber;
    static int INF = 250_000_000;

    static List<Node>[] map;
    static int[] minDistance;

    private static class Node {

        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                "vertex=" + vertex +
                ", weight=" + weight +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            nodeNumber = Integer.parseInt(tokenizer.nextToken());
            roadNumber = Integer.parseInt(tokenizer.nextToken());
            wormHoleNumber = Integer.parseInt(tokenizer.nextToken());

            map = new ArrayList[nodeNumber + 1];
            minDistance = new int[nodeNumber + 1];

            for (int i = 0; i < nodeNumber + 1; i++) {
                map[i] = new ArrayList<>();
            }

            for (int i = 0; i < roadNumber + wormHoleNumber; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                if (i < roadNumber) {
                    map[start].add(new Node(end, weight));
                    map[end].add(new Node(start, weight));
                    continue;
                }
                map[start].add(new Node(end, -weight));
            }

            if (bellmanFord()) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }

    private static boolean bellmanFord() {
        Arrays.fill(minDistance, INF);
        minDistance[1] = 0;

        for (int repeat = 1; repeat < nodeNumber; repeat++) {
            for (int start = 1; start <= nodeNumber; start++) {
                for (Node next : map[start]) {
                    int nextWeight = minDistance[start] + next.weight;
                    if (nextWeight < minDistance[next.vertex]) {
                        minDistance[next.vertex] = nextWeight;
                    }
                }
            }
        }

        for (int start = 1; start <= nodeNumber; start++) {
            for (Node next : map[start]) {
                int nextWeight = minDistance[start] + next.weight;
                if (nextWeight < minDistance[next.vertex]) {
                    return false;
                }
            }
        }
        return true;
    }
}
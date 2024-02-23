import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        parents = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        Edge[] nodes = new Edge[m];
        for (int i = 0; i < m; i++) {
            tokenizer =  new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            nodes[i] = new Edge(start, end, weight);
        }
        Arrays.sort(nodes);

        long answer = 0;
        for (Edge node : nodes) {
            if (union(node.start, node.end)) {
                answer += node.weight;
            }
        }
        System.out.println(answer);
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return false;

        parents[x] = y;
        return true;
    }
}
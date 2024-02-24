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

        int houseNumber = Integer.parseInt(tokenizer.nextToken());
        int roadNumber = Integer.parseInt(tokenizer.nextToken());

        parents = new int[houseNumber+1];
        for (int i = 0; i < houseNumber + 1; i++) {
            parents[i] = i;
        }

        Edge[] edges = new Edge[roadNumber];
        for (int i = 0; i < roadNumber; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            edges[i] = new Edge(start, end, weight);
        }
        Arrays.sort(edges);

        int answer = 0;
        int lastWeight = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                answer += edge.weight;
                lastWeight = edge.weight;
            }
        }
        System.out.println(answer - lastWeight);
    }

    private static class Edge implements Comparable<Edge> {
        int start, end, weight;

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
        
        // 사이클 형성
        if (x == y) return false;
        
        parents[x] = y;
        return true;
    }
}
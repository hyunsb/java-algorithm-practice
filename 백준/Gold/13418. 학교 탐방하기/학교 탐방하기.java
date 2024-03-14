import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        Edge[] edges = new Edge[m+1];
        for (int i = 0; i < m + 1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int flag = Integer.parseInt(tokenizer.nextToken());

            edges[i] = new Edge(start, end, flag);
        }

        int minFatigue = findFatigue(edges.clone(), true);
        int maxFatigue = findFatigue(edges.clone(), false);
        System.out.println(maxFatigue - minFatigue);
    }

    private static class Edge implements Comparable<Edge> {
        int start, end, flag;

        public Edge(int start, int end, int flag) {
            this.start = start;
            this.end = end;
            this.flag = flag;
        }

        @Override
        public int compareTo(Edge that) {
            return this.flag - that.flag;
        }
    }

    // true == 최소 피로도, false == 최대 피로도
    private static int findFatigue(Edge[] edges, boolean flag) {
        parents = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        if (flag) Arrays.sort(edges, Comparator.reverseOrder());
        else Arrays.sort(edges);

        int uphillCount = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                if (edge.flag == 0) uphillCount += 1;
            }
        }
        return (int) Math.pow(uphillCount, 2);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;

        parents[x] = y;
        return true;
    }
}
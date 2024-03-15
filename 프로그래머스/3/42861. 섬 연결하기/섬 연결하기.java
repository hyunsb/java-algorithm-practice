import java.util.Arrays;

class Solution {

    static int[] parents;

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        Edge[] edges = new Edge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int weight = costs[i][2];
            
            edges[i] = new Edge(start, end, weight);
        }
        Arrays.sort(edges);

        int weight = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                weight += edge.weight;
            }
        }
        return weight;
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
        if (x == y) return false;
        
        parents[x] = y;
        return true;
    }
}
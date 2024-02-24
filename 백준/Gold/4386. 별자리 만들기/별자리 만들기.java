import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int[] parents;
    static Point[] points;

    private static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return (int) (this.weight - that.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int starNumber = Integer.parseInt(bufferedReader.readLine());

        parents = new int[starNumber];
        for (int i = 0; i < starNumber; i++) {
            parents[i] = i;
        }

        StringTokenizer tokenizer;
        points = new Point[starNumber];
        for (int i = 0; i < starNumber; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            double x = Double.parseDouble(tokenizer.nextToken());
            double y = Double.parseDouble(tokenizer.nextToken());

            points[i] = new Point(x, y);
        }

        ArrayList<Edge> edges = new ArrayList<>();
        for (int start = 0; start < starNumber; start++) {
            for (int end = start+1; end < starNumber; end++) {
                double xd = Math.pow(points[start].x - points[end].x, 2);
                double yd = Math.pow(points[start].y - points[end].y, 2);
                double weight = Math.sqrt(xd + yd);

                edges.add(new Edge(start, end, weight));
            }
        }
        edges.sort(Edge::compareTo);

        double answer = 0;
        for (Edge edge : edges) {
            if (union(edge.start, edge.end)) {
                answer += edge.weight;
            }
        }
        System.out.println(answer);
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
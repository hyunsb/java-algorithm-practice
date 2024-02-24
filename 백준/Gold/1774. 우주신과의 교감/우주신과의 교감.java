import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int[] parents;

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Route implements Comparable<Route> {
        int start, end;
        double weight;

        public Route(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Route that) {
            return Double.compare(this.weight, that.weight);
        }

        @Override
        public String toString() {
            return "Route{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        parents = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        Point[] points = new Point[n+1];
        for (int i = 1; i < n+1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            points[i] = new Point(x, y);
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            union(x, y);
        }

        ArrayList<Route> routes = new ArrayList<>();
        for (int start = 1; start < n+1; start++) {
            for (int end = start+1; end < n + 1; end++) {
                double xd = Math.pow(points[start].x - points[end].x, 2);
                double yd = Math.pow(points[start].y - points[end].y, 2);
                double weight = Math.sqrt(xd + yd);

                routes.add(new Route(start, end, weight));
            }
        }
        routes.sort(Route::compareTo);

        double answer = 0;
        for (Route route : routes) {
            if (union(route.start, route.end)) {
                answer += route.weight;
            }
        }
        System.out.printf("%.2f%n", answer);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false; // 사이클이 형성되어 있음

        parents[x] = y; // 통로 연결하고 반환
        return true;
    }
}
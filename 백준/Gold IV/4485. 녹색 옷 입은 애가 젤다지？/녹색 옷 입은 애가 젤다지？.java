import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int INF = 1250;
    static int[][] map, minDistance;
    static boolean[][] isVisit;

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int weight;

        public Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point that) {
            return this.weight - that.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        int n;
        while ((n = Integer.parseInt(bufferedReader.readLine())) != 0) {
            map = new int[n][n];
            minDistance = new int[n][n];
            isVisit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(minDistance[i], INF);
            }

            StringTokenizer tokenizer;
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            dijkstra();
            //Problem 1: 20
            //Problem 2: 19
            //Problem 3: 36
            System.out.println("Problem " + (count++) + ": " + minDistance[n-1][n-1]);
        }
    }

    private static void dijkstra() {
        Queue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, map[0][0]));
        minDistance[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            if (isVisit[cx][cy]) continue;
            isVisit[cx][cy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];
                try {
                    int nw = current.weight + map[nx][ny];
                    if (minDistance[nx][ny] > nw) {
                        minDistance[nx][ny] = nw;
                        queue.add(new Point(nx, ny, nw));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
    }
}
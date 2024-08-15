import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};
    static int[][] map;
    static int answer = 0;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }

    private static void BFS(int x, int y) {
        count+=1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[x][y] = 0;
        int width = 0;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            width += 1;

            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + mx[i];
                int ny = currentPoint.y + my[i];
                try {
                    if (map[nx][ny] == 1) {
                        queue.add(new Point(nx, ny));
                        map[nx][ny] = 0;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }

        answer = Math.max(answer, width);
    }

    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
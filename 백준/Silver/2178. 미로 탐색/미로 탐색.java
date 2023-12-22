import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;
    static int answer = Integer.MAX_VALUE;

    // DFS 사용 시 시간 초과
    public static void dfs(int x, int y, int move) {
        if (x == n-1 && y == m-1) {
            answer = Math.min(answer, move);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            try {
                if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    dfs(nx, ny, move + 1);
                    isVisited[nx][ny] = false;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + moveX[i];
                int nextY = current.y + moveY[i];

                try {
                    if (map[nextX][nextY] > 0 && !isVisited[nextX][nextY]) {
                        queue.add(new Point(nextX, nextY));
                        map[nextX][nextY] = map[current.x][current.y] + 1;
                        isVisited[nextX][nextY] = true;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {}
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] read = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(read[j]);
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }
}
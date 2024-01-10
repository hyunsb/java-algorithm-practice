import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    static int[][] map;
    static boolean[][] isVisited;

    private static void BFS(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int cd = current.distance;
            map[cx][cy] = cd;

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];
                try {
                    if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        queue.add(new Point(nx, ny, cd + 1));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
    }

    private static class Point {
        public int x;
        public int y;
        public int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = number;
                if (number == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        BFS(startX, startY);
        StringBuilder answer = new StringBuilder();
        int number;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                number = map[i][j];
                if (!isVisited[i][j] && map[i][j] == 1) {
                    number = -1;
                }
                answer.append(number).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
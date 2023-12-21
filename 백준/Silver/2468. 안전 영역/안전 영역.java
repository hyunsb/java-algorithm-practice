import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    static int[][] map;
    static boolean[][] isVisit;
    static int height;
    static int count;
    static int answer = 1;

    public static void dfs(int x, int y) {
        isVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            try {
                if (map[nx][ny] > height && !isVisit[nx][ny]) {
                    dfs(nx, ny);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n][n];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = h;
                if (minH > h) minH = h;
                if (maxH < h) maxH = h;
            }
        }

        for (int h = minH; h < maxH; h++) {
            height = h;
            count = 0;
            isVisit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > height && !isVisit[i][j]) {
                        dfs(i, j);
                        count += 1;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
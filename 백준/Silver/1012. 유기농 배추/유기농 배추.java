import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    static int n, m, k;
    static int[][] map;
    static boolean[][] isVisit;
    static int count;

    public static void dfs(int x, int y) {
        isVisit[x][y] = true;

        for (int i = 0; i < moveX.length; i++) {
            int tempX = x + moveX[i];
            int tempY = y + moveY[i];

            try {
                if (map[tempX][tempY] == 1 && !isVisit[tempX][tempY]) {
                    dfs(tempX, tempY);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(bufferedReader.readLine());
        for (int re = 0; re < repeat; re++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            k = Integer.parseInt(tokenizer.nextToken());

            map = new int[m][n];
            isVisit = new boolean[m][n];
            count = 0;

            for (int i = 0; i < k; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());

                int y = Integer.parseInt(tokenizer.nextToken());
                int x = Integer.parseInt(tokenizer.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !isVisit[i][j]) {
                        dfs(i, j);
                        count += 1;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
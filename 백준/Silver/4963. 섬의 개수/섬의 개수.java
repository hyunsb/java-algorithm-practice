import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] moveX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int n, m;
    static int[][] map;
    static boolean[][] isVisit;
    static int count;

    public static void dfs(int x, int y) {
        isVisit[x][y] = true;

        for (int i = 0; i < moveX.length; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            try {
                if (map[nextX][nextY] == 1 && !isVisit[nextX][nextY]) {
                    dfs(nextX, nextY);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String read = bufferedReader.readLine();
            if (read.equals("0 0")) break;

            StringTokenizer tokenizer = new StringTokenizer(read);
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            count = 0;
            isVisit = new boolean[m][n];
            map = new int[m][n];
            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    static char[][] map;
    static Set<Character> checker = new HashSet<>();
    static int result;

    public static void dfs(int x, int y, int move) {
        for (int i = 0; i < 4; i++) {
            int nx = x + moveX[i];
            int ny = y + moveY[i];

            try {
                if (checker.add(map[nx][ny])) {
                    dfs(nx, ny, move+1);
                    checker.remove(map[nx][ny]);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }
        result = Math.max(result, move);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = bufferedReader.readLine().toCharArray();
        }

        checker.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(result);
    }
}
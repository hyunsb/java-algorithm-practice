import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[][] map;
    static boolean[] isVisit;
    static int count;

    public void dfs(int start) {
        isVisit[start] = true;
        count += 1;

        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 1 && !isVisit[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        m = Integer.parseInt(bufferedReader.readLine());
        map = new int[n+1][n+1];
        isVisit = new boolean[n+1];

        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        Main main = new Main();
        main.dfs(1);
        System.out.println(count-1);
    }
}

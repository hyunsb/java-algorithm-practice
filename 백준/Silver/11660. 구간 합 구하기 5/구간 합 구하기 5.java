import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(tokenizer.nextToken());
                dp[i][j] = (dp[i-1][j] + dp[i][j-1] + num) - dp[i-1][j-1];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            int sum = dp[x2][y2] - (dp[x2][y1-1] + dp[x1-1][y2]) + dp[x1-1][y1-1];
            answer.append(sum).append("\n");
        }
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer;

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] dp = triangle.clone();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {

                int left = 0;
                int right = 0;

                if (j != 0) left = dp[i-1][j-1];
                if (j != i) right = dp[i-1][j];

                dp[i][j] = Math.max(right, left) + dp[i][j];
            }
        }

        int answer = 0;
        for (int i : dp[n - 1]) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
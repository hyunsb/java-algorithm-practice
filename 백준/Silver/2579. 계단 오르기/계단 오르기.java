import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            score[i] = Integer.parseInt(bufferedReader.readLine());
        }

        dp[1] = score[1];
        if (n > 1) dp[2] = score[1] + score[2];
        if (n > 2) dp[3] = Math.max((score[2] + score[3]), (score[1] + score[3]));

        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.max((dp[i - 2]), (dp[i - 3] + score[i - 1])) + score[i];
        }

        System.out.println(dp[n]);
    }
}
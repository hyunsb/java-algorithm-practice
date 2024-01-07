import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static Integer[][] dp = new Integer[41][2];

    private static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            Integer[] temp1 = fibonacci(n-1);
            Integer[] temp2 = fibonacci(n-2);
            dp[n][0] = temp1[0] + temp2[0];
            dp[n][1] = temp1[1] + temp2[1];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(bufferedReader.readLine());
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < repeat; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
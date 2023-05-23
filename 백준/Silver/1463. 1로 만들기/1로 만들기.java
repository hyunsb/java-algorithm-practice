import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;

        System.out.println(DFS(N));
    }

    public static int DFS(int n){
        if (dp[n] == Integer.MAX_VALUE) {
            if (n % 6 == 0) {
                dp[n] = Math.min(Math.min(DFS(n/3)+1, DFS(n/2)+1), DFS(n-1)+1);
            } else if (n % 3 == 0) {
                dp[n] = Math.min(DFS(n/3)+1, DFS(n-1)+1);
            } else if (n % 2 == 0) {
                dp[n] = Math.min(DFS(n/2)+1, DFS(n-1)+1);
            } else {
                dp[n] = DFS(n-1)+1;
            }
        }
        return dp[n];
    }
}
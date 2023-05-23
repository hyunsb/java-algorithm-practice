import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        char[] chars = S.toCharArray();
        int[] dp = new int[M];
        int answer = 0;

        for (int i = 1; i < M-1; i++) {
            if (chars[i] == 'O' && chars[i+1] == 'I') {
                dp[i+1] = dp[i-1] + 1;
                if (dp[i+1] >= N && chars[i-2 * N+1] == 'I')
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
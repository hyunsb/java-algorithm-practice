import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int fiboCnt = 0;
    static int fibonacciCnt = 0;

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 1;
        fibo(n);
        fibonacci(n);

        System.out.println(fiboCnt + " " + fibonacciCnt);
    }

    static int fibo(int n) {
        if (n == 1 || n == 2) {
            fiboCnt++;
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }

    static int fibonacci(int n) {
        if (memo[n] == 0) {
            fibonacciCnt++;
            memo[n] = fibonacci(n-1) + fibonacci(n-2);
        }
        return memo[n];
    }
}
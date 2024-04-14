import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static long[] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        cache = new long[n+1];
        System.out.println(fibonacci(n));
    }

    static long fibonacci(int n) {
        if (n == 0) return cache[n];
        if (n == 1 || n == 2) return cache[n] = 1;
        if (cache[n] != 0) return cache[n];
        return cache[n] = fibonacci(n-1) + fibonacci(n-2);
    }
}
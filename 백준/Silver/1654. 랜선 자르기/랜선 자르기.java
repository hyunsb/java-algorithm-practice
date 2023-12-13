import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        long k = Long.parseLong(tokenizer.nextToken());
        long[] arr = new long[n];

        long left = 1, right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(bufferedReader.readLine());
            if (right < arr[i]) right = arr[i];
        }

        while (left <= right) {
            long target = (left + right) / 2;
            long count = 0;
            
            for (long i : arr) {
                count += i / target;
            }

            if (count >= k) {
                left = target + 1;
            } else {
                right = target - 1;
            }
        }
        System.out.println(left - 1);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n+1];

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int sum = 0;
        int length = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (start <= end && end <= n) {
            if (sum < s) {
                sum += arr[end++];
            } else {
                int cur = end - start;
                if (cur < length) length = cur;
                sum -= arr[start++];
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
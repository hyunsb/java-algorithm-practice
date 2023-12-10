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
        int[] nums = new int[n];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        int start = 0, end = 0;
        while (end < n) {
            while (end < m - 1) {
                currentSum += nums[end++];
            }
            currentSum += nums[end++];
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= nums[start++];
        }
        System.out.println(maxSum);
    }
}
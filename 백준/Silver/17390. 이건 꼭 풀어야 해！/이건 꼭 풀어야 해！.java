import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());

        int[] nums = new int[n+1];
        int[] sums = new int[n+1];

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < n+1; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(nums);

        for (int i = 1; i < n+1; i++) {
            if (i == 1) {
                sums[i] = nums[i];
                continue;
            }
            sums[i] = sums[i-1] + nums[i];
        }

        while (q-- > 0) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            System.out.println(sums[end] - sums[start - 1]);
        }
    }
}
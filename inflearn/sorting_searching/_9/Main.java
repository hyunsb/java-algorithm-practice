package inflearn.sorting_searching._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];

        int right = 0;
        int left = 0;

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
            right += arr[i];
            if (i == n -1) left = arr[i];
        }

        int answer = Integer.MAX_VALUE;
        while (left <= right) {
            int target = (right + left) / 2;

            int count = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > target) {
                    sum = arr[i];
                    count += 1;
                } else {
                    sum += arr[i];
                }
            }
            if (count <= m) {
                answer = Math.min(answer, target);
                right = target - 1;
            } else {
                left = target + 1;
            }
        }
        System.out.println(answer);
    }
}

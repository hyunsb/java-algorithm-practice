package inflearn.twoPointers_sildingWindow._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n-1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int answer = 0;
        int start = 0, sum = 0;
        for (int end = 0; end < numbers.length; end++) {
            sum += numbers[end];
            if (sum == n) answer += 1;
            while (sum >= n) {
                sum -= numbers[start++];
                if (sum == n) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}

package inflearn.twoPointers_sildingWindow._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += numbers[end++];
            if (sum == s) answer += 1;
            while (sum >= s) {
                sum -= numbers[start++];
                if (sum == s) answer += 1;
            }
        }
        System.out.println(answer);
    }
}

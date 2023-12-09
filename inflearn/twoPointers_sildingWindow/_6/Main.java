package inflearn.twoPointers_sildingWindow._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start = 0, end = 0;
        int answer = 0;
        int zeroCount = 0;

        while (end < n) {
            if (numbers[end++] == 0) zeroCount += 1;
            while (zeroCount > k) {
                if (numbers[start++] == 0) zeroCount -= 1;
            }
            answer = Math.max(answer, end - start);
        }

        System.out.println(answer);
    }
}

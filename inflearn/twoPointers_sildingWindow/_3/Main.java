package inflearn.twoPointers_sildingWindow._3;

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

        int[] sales = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) sales[i] = Integer.parseInt(stringTokenizer.nextToken());

        int maxSales = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0;

        while (end < n) {
//            System.out.print("start: " + start + " end: " + end);
            if (end < k) {
                sum += sales[end];
                end += 1;
            } else {
                sum += sales[end++];
                sum -= sales[start++];
            }
//            System.out.println("  | sum: " + sum + " max: " + maxSales);
            maxSales = Math.max(maxSales, sum);
        }

        System.out.println(maxSales);
    }
}

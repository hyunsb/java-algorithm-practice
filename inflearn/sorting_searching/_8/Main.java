package inflearn.sorting_searching._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr, m) + 1);

        int left = 0;
        int right = arr.length - 1;
        while (left != right) {
            int i = left + right / 2;
            if (arr[i] == m) {
                System.out.println(i + 1);
                return;
            }
            if (arr[i] > m) {
                right = i;
            } else if (arr[i] < m){
                left = i;
            }
        }
    }
}

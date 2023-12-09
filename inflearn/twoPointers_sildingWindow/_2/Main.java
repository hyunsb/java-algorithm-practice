package inflearn.twoPointers_sildingWindow._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr1 = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] arr2 = new int[m];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> answer = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while (index1 < n  && index2 < m) {
            int a = arr1[index1];
            int b = arr2[index2];
            if (a == b) {
                answer.add(a);
                index1+=1;
                index2+=1;
            } else if (a > b) {
                index2 += 1;
            } else {
                index1 += 1;
            }
        }

        answer.forEach(integer -> {
            System.out.print(integer + " ");
        });
    }
}

package inflearn.twoPointers_sildingWindow._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr1 = new int[n];
        String[] numbers1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(numbers1[i]);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] arr2 = new int[m];
        String[] numbers2 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(numbers2[i]);
        }

        solution(arr1, arr2);
    }

    private static void solution(int[] arr1, int[] arr2) {
        int index1 = 0, index2 = 0;
        int[] answer = new int[arr1.length + arr2.length];

        for (int i = 0; i < answer.length; i++) {

            if (index1 == arr1.length) {
                answer[i] = arr2[index2++];
            } else if (index2 == arr2.length) {
                answer[i] = arr1[index1++];
            }

            else {
                if (arr1[index1] >= arr2[index2]) {
                    answer[i] = arr2[index2++];
                } else {
                    answer[i] = arr1[index1++];
                }
            }
        }
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }
}

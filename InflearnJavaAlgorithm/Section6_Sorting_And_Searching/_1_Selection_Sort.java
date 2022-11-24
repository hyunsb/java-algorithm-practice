package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Scanner;

public class _1_Selection_Sort {
    public static void main(String[] args) {
        _1_Selection_Sort T = new _1_Selection_Sort();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int i : T.solution(arr)) System.out.print(i + " ");
    }

    public int[] solution(int[] arr){
        for(int i=0; i<arr.length; i++){
            int minIdx = i;

            for(int j=i+1; j<arr.length; j++)
                if(arr[minIdx] > arr[j])
                    minIdx = j;

            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
}

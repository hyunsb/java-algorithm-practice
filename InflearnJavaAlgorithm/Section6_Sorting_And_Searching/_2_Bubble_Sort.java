package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Scanner;

public class _2_Bubble_Sort {
    public static void main(String[] args) {
        _2_Bubble_Sort T = new _2_Bubble_Sort();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int i : T.solution(arr)) System.out.print(i + " ");
    }

    public int[] solution(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1] > arr[j]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}

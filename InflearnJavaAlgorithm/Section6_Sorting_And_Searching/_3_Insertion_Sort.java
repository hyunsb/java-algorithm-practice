package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Scanner;

public class _3_Insertion_Sort {
    public static void main(String[] args) {
        _3_Insertion_Sort T = new _3_Insertion_Sort();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        for(int i : T.solution(arr)) System.out.print(i + " ");
    }

    public int[] solution(int[] arr){
        for(int i=1; i<arr.length; i++){
            int temp = arr[i];
            int prev;

            for(prev=i-1; prev>=0; prev--){
                if(temp < arr[prev])
                    arr[prev+1] = arr[prev];
                else break;
            }
            arr[prev+1] = temp;
        }
        return arr;
    }
}

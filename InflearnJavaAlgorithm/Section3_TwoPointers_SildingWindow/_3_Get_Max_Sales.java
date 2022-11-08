package InflearnJavaAlgorithm.Section3_TwoPointers_SildingWindow;

import java.util.Scanner;

public class _3_Get_Max_Sales {
    public int solution(int n, int k, int[] salses){
        int maxSales = Integer.MIN_VALUE;

        for(int i=0; i<n-k; i++){
            int salse = 0;
            for(int j=0; j<k; j++){
                salse += salses[i+j];
            }
            maxSales = Math.max(maxSales, salse);
        }

        return maxSales;
    }



    public static void main(String[] args) {
        _3_Get_Max_Sales T = new _3_Get_Max_Sales();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] salses = new int[n];
        for(int i=0; i<n; i++) salses[i] = sc.nextInt();

        System.out.println(T.solution(n, k, salses));
    }
}

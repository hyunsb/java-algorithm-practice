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

    public int solution2(int n, int k, int[] sales){
        int sale = 0;
        for(int i=0; i<k; i++) sale += sales[i];
        int maxSales = sale;

        for(int i=k; i<n; i++){
            sale = sale + sales[i] - sales[i-k];
            //sale += (sales[i] - sales[i-k]);
            maxSales = Math.max(maxSales, sale);
        }
        return maxSales;
    }

    public static void main(String[] args) {
        _3_Get_Max_Sales T = new _3_Get_Max_Sales();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] sales = new int[n];
        for(int i=0; i<n; i++) sales[i] = sc.nextInt();

        System.out.println(T.solution(n, k, sales));
        System.out.println(T.solution2(n, k, sales));
    }
}

package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _4_Recursion_Fibonacci {
    static int[] fibonacci;

    public static void main(String[] args) {
        _4_Recursion_Fibonacci T = new _4_Recursion_Fibonacci();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fibonacci = new int[n+1];
        T.DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibonacci[i] + " ");
    }

    public int DFS(int n){
        if(fibonacci[n] != 0)
            return fibonacci[n];

        if(n == 1) return fibonacci[n] = 1;
        else if (n == 2) fibonacci[n] = 1;
        else return fibonacci[n] = DFS(n-2) + DFS(n-1);

        return n;
    }
}

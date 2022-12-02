package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _3_Recursion_Factorial {
    public static void main(String[] args) {
        _3_Recursion_Factorial T = new _3_Recursion_Factorial();
        Scanner sc = new Scanner(System.in);

        System.out.println(T.factorial(sc.nextInt()));

    }

    public int factorial(int n){
        if(n == 1) return 1;
        else return n * factorial(n-1);
    }

}

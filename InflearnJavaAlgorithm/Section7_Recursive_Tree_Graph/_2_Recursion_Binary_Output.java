package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _2_Recursion_Binary_Output {
    public static void main(String[] args) {
        _2_Recursion_Binary_Output T = new _2_Recursion_Binary_Output();
        Scanner sc = new Scanner(System.in);

        T.castingBinary(sc.nextInt());
        T.DFS(sc.nextInt());
    }

    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public void castingBinary(int decimal){
        int num = decimal / 2;

        if (num > 0)
            castingBinary(num);
        else {
            System.out.print(decimal % 2);
            return;
        }

        System.out.print(decimal % 2);
    }

}

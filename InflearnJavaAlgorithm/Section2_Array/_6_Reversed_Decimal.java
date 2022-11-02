package InflearnJavaAlgorithm.Section2_Array;

import java.util.ArrayList;
import java.util.Scanner;

public class _6_Reversed_Decimal {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                res = res * 10 + (tmp%10);
                tmp /= 10;
            }
            if(isPrime(res)) answer.add(res);
        }
        return answer;
    }
    public boolean isPrime(int num){
        if (num==1) return false;
        for (int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _6_Reversed_Decimal T = new _6_Reversed_Decimal();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}

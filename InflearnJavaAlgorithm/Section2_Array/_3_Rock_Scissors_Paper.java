package InflearnJavaAlgorithm.Section2_Array;

import java.util.Scanner;

public class _3_Rock_Scissors_Paper {
    public String solution(int num, int[] A, int[] B){
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<num; i++){
            if (A[i] == B[i]) answer.append("D");
            else if (A[i]==1 && B[i]==3) answer.append("A");
            else if (A[i]==2 && B[i]==1) answer.append("A");
            else if (A[i]==3 && B[i]==2) answer.append("A");
            else answer.append("B");
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        _3_Rock_Scissors_Paper T = new _3_Rock_Scissors_Paper();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] A = new int[num], B = new int[num];
        for(int i=0; i < num; i++) A[i] = sc.nextInt();
        for(int i=0; i < num; i++) B[i] = sc.nextInt();

        for(char c : T.solution(num, A, B).toCharArray()) System.out.println(c);
    }
}

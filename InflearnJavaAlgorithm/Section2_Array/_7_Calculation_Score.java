package InflearnJavaAlgorithm.Section2_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _7_Calculation_Score {
    public int solution(int length, int[] errata){
        int answer = 0;
        int count = 0;

        for(int check : errata) {
            if (check == 0) count = 0;
            if(check == 1) {
                answer = answer + count + 1;
                count++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _7_Calculation_Score T = new _7_Calculation_Score();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] errata = new int[length];
        for (int i=0; i<length; i++){
            errata[i] = sc.nextInt();
        }

        System.out.println(T.solution(length, errata));
    }
}

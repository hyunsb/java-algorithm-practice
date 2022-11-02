package InflearnJavaAlgorithm.Section2_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1_Greater_Number {
    public List<Integer> solution(int num, int[] numList){
        List<Integer> answer = new ArrayList<Integer>();
        int tmp = Integer.MIN_VALUE;
        for(int i : numList) {
            if (tmp < i) answer.add(i);
            tmp = i;
        }

        return answer;
    }

    public static void main(String[] args) {
        _1_Greater_Number T = new _1_Greater_Number();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] numList = new int[num];
        for(int i=0; i < num; i++) numList[i] = sc.nextInt();

        for(int i : T.solution(num, numList)) System.out.print(i + " ");
    }
}

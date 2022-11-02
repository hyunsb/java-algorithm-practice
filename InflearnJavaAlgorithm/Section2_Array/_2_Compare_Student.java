package InflearnJavaAlgorithm.Section2_Array;

import java.util.Scanner;

public class _2_Compare_Student {
    public int solution(int num, int[] numList){
        int answer = 0;

        int max = Integer.MIN_VALUE;
        for (int stud : numList) {
            if(max < stud) {
                answer++;
                max = stud;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _2_Compare_Student T = new _2_Compare_Student();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] numList = new int[num];
        for(int i=0; i < num; i++) numList[i] = sc.nextInt();

        System.out.println(T.solution(num, numList));
    }
}

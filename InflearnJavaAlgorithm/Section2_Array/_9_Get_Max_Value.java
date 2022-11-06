package InflearnJavaAlgorithm.Section2_Array;

import java.util.Scanner;

public class _9_Get_Max_Value {
    public int solution(int length, int[][] grating){
        int maxValue = Integer.MIN_VALUE;
        int sumRow, sumCal;

        for(int i=0; i<length; i++){
            sumRow = sumCal = 0;
            for(int j=0; j<length; j++){
                sumRow += grating[i][j];
                sumCal += grating[j][i];
            }
            maxValue = Math.max(sumRow, maxValue);
            maxValue = Math.max(sumCal, maxValue);
        }

        sumRow = sumCal = 0;
        for (int i=0; i<length; i++){
            sumCal += grating[i][i];
            sumRow += grating[i][length-1-i];
        }
        maxValue = Math.max(sumRow, maxValue);
        maxValue = Math.max(sumCal, maxValue);

        return maxValue;
    }

    public static void main(String[] args) {
        _9_Get_Max_Value T = new _9_Get_Max_Value();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] grating = new int[length][length];
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                grating[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(length, grating));
    }
}

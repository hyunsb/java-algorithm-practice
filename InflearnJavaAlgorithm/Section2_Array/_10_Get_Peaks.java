package InflearnJavaAlgorithm.Section2_Array;

import java.util.Scanner;

public class _10_Get_Peaks {

    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    public int solution(int length, int[][] heights){
        int countPeaks = 0;



        return countPeaks;
    }

    public static void main(String[] args) {
        _10_Get_Peaks T = new _10_Get_Peaks();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] heights = new int[length][length];
        for (int i=0; i<length; i++){
            for (int j=0; j<length; j++){
                heights[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(length, heights));

    }
}

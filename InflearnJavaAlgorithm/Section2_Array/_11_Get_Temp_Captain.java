package InflearnJavaAlgorithm.Section2_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11_Get_Temp_Captain {
    public int solution(int length, int[][] studentInfo){
        int captain = 0;
        int maxClassmate = Integer.MIN_VALUE;

        for (int i=0; i<length; i++){
            int countClassmate = 0;
            List<Integer> compareList = new ArrayList<>();
            compareList.add(i);

            for (int j=0; j<5; j++){
                for (int k=0; k<length; k++){
                    if (studentInfo[i][j] == studentInfo[k][j]
                            && !compareList.contains(k)){
                        countClassmate += 1;
                        compareList.add(k);
                    }
                }
            }

            if (maxClassmate < countClassmate) {
                captain = i+1;
                maxClassmate = countClassmate;
            }
        }

        return captain;
    }

    public static void main(String[] args) {
        _11_Get_Temp_Captain T = new _11_Get_Temp_Captain();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[][] studentInfo = new int[length][5];
        for (int i=0; i<length; i++){
            for (int j=0; j<5; j++){
                studentInfo[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(length, studentInfo));
    }
}

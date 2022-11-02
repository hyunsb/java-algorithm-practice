package Level1;

import java.util.Arrays;

public class GymSuit {
    public static void main(String[] args) {
        // 프로그래머스 -> 탐욕법 -> 체육복 문제
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

//        int count = 0;
//
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//
//        for(int i=0; i < lost.length; i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if (lost[i] == reserve[j]) {
//                    lost[i] = -1;
//                    reserve[j] = -1;
//                    count++;
//                    break;
//                }
//            }
//        }
//
//        for(int i=0; i < lost.length; i++){
//            for(int j=0; j < reserve.length; j++) {
//                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1){
//                    count++;
//                    reserve[j] = -1;
//                    break;
//                }
//            }
//        }

        System.out.println(solution2(5, lost, reserve));

    }

    public static int solution(int n, int[] lost, int[] reserve) {
        return Math.min(n - lost.length + reserve.length, n);
    }

    public static int solutionMy(int n, int[] lost, int[] reserve) {
        int count = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return n-lost.length+count;
    }

    public static int solution2(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] stud = new int[n];
        for(int l : lost){
            stud[l-1]--;
        }
        for(int r : reserve){
            stud[r-1]++;
        }
        for(int s : stud){
            System.out.print(s + " ");
        }

        for(int i=0; i < stud.length; i++){
            if(stud[i] == -1){
                if(i-1 >= 0 && stud[i-1] == 1){
                    stud[i]++;
                    stud[i-1]--;
                }
                else if(i+1 <= stud.length && stud[i+1] == 1){
                    stud[i]++;
                    stud[i+1]++;
                }else{
                    answer--;
                }
            }
        }

        return answer;
    }
}

package InflearnJavaAlgorithm.Section3_TwoPointers_SildingWindow;

import java.util.Scanner;

public class _5_Continuous_Natural_Number {
    public int solution(int n) {
        int answer=0, sum=0, lt=1;
        for(int rt=1; rt<n; rt++){
            sum += rt;
            if(sum == n) answer++;

            while (sum >= n){
                sum -= lt++;
                if(sum == n) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _5_Continuous_Natural_Number T = new _5_Continuous_Natural_Number();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(T.solution(n));

    }
}

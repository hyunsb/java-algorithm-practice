package InflearnJavaAlgorithm.Section3_TwoPointers_SildingWindow;

import java.util.Map;
import java.util.Scanner;

public class _6_Max_Consecutive_Number_Sub_Sequence {
    public int solution(int n, int k, int[] sequence){
        int answer = 0, lt = 0;
        int zeroCount = 0;

        for(int rt=0; rt<n; rt++){
            if(sequence[rt] == 0) zeroCount += 1;
            if(zeroCount > k)
                answer = Math.max(answer, rt - lt);
            while (zeroCount > k){
                if(sequence[lt] == 0)
                    zeroCount--;
                lt++;
            }
        }
        return answer;
    }

    public int solution2(int n, int k, int[] sequence){
        int answer = 0, cnt = 0, lt = 0;
        for (int rt=0; rt<n; rt++){
            if(sequence[rt] == 0) cnt++;
            while (cnt > k) {
                if (sequence[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        _6_Max_Consecutive_Number_Sub_Sequence T = new _6_Max_Consecutive_Number_Sub_Sequence();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] squence = new int[n];
        for(int i=0; i<n; i++) squence[i] = sc.nextInt();

        System.out.println(T.solution(n, k, squence));
        System.out.println(T.solution2(n, k, squence));
    }
}

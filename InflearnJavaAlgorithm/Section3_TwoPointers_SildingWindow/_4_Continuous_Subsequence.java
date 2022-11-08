package InflearnJavaAlgorithm.Section3_TwoPointers_SildingWindow;

import java.util.Scanner;

public class _4_Continuous_Subsequence {

    public int solution(int n, int m, int[] sequence){
        int answer=0;
        int lt=0, rt=0;
        int sum = sequence[rt];
        rt++;
        if(sum == m) answer++;

        while (rt < n){
            if (sum < m) {
                sum += sequence[rt];
                rt++;
            }else if (sum >= m) {
                sum -= sequence[lt];
                lt++;
            }
            if(sum == m) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        _4_Continuous_Subsequence T = new _4_Continuous_Subsequence();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] sequence = new int[n];
        for(int i=0; i<n; i++) sequence[i] = sc.nextInt();

        System.out.println(T.solution(n, m, sequence));
    }

}

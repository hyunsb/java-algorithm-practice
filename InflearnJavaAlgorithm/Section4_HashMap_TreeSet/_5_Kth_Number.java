package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class _5_Kth_Number {
    // 인프런 4-5 K번째 큰 수
    public static void main(String[] args) {
        _5_Kth_Number T = new _5_Kth_Number();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] score = new int[n];
        for(int i=0; i<n; i++) score[i] = sc.nextInt();
        System.out.println(T.solution(n, k, score));
    }

    public int solution2(int n, int k, int[] score){
        int asnwer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    Tset.add(score[i] + score[j] + score[l]);
                }
            }
        }

        int cnt = 0;
        for(int x : Tset){
            cnt++;
            if(cnt==k)
                return  x;
        }
        return asnwer;
    }

    public int solution(int n, int k, int[] score){
        TreeSet<Integer> scoreSet = new TreeSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)
                    continue;

                for(int l=0; l<n; l++){
                    if(j == l || i == l)
                        continue;

                    scoreSet.add(score[i] + score[j] + score[l]);
                }
            }
        }

        if(scoreSet.size() < k){
            return -1;
        }

        for(int i=0; i<k-1; i++)
            scoreSet.pollLast();

        return scoreSet.last();
    }
}

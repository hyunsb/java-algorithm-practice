package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _6_Mischievous_Boy {
    public static void main(String[] args) {
        _6_Mischievous_Boy T = new _6_Mischievous_Boy();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0; i<n; i++) height[i] = sc.nextInt();

        for(int i : T.solution(n, height)) System.out.print(i + " ");
    }

    public List<Integer> solution(int n, int[] height){
        List<Integer> answer = new ArrayList<>();

        int[] tmp = height.clone();
        Arrays.sort(tmp);

        for(int i=0; i<n; i++){
            if(height[i] != tmp[i])
                answer.add(i+1);
        }

        return answer;
    }
}

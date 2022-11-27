package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5_Check_For_Duplicates {
    public static void main(String[] args) {
        _5_Check_For_Duplicates T = new _5_Check_For_Duplicates();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stud = new int[n];
        for(int i=0; i<n; i++) stud[i] = sc.nextInt();

        System.out.println(T.solution(n, stud));
    }

    public char solution(int n, int[] stud){
        char answer = 'U';
        List<Integer> list = new ArrayList<>();
        for(int i : stud){
            if(list.contains(i)) return 'D';
            list.add(i);
        }

        return answer;
    }
}

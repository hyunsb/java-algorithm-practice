package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.*;

public class _5_Check_For_Duplicates {
    public static void main(String[] args) {
        _5_Check_For_Duplicates T = new _5_Check_For_Duplicates();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stud = new int[n];
        for(int i=0; i<n; i++) stud[i] = sc.nextInt();

        System.out.println(T.solution(n, stud));
        System.out.println(T.solution2(n, stud));
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

    public char solution2(int n, int[] stud){
        char answer = 'U';
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : stud){
            if(map.getOrDefault(i, 0) != 0) return 'D';
            map.put(i, 1);
        }

        return answer;
    }

    public char solution3(int n, int[] stud){
        char answer = 'U';
        Arrays.sort(stud);
        for(int i=0; i<n-1; i++){
            if(stud[i] == stud[i+1]) return 'D';
        }

        return answer;
    }
}

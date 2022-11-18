package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class _3_Hash_Type_Of_Sales {
    public static void main(String[] args) {
        _3_Hash_Type_Of_Sales T = new _3_Hash_Type_Of_Sales();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for(int i=0; i<n; i++) sales[i] = sc.nextInt();

        for(int salesType : T.solution(n, k, sales)) System.out.print(salesType + " ");
    }

    public List<Integer> solution(int n, int k, int[] sales){
        List<Integer> answer = new ArrayList<>();
        int lt=0;

        for(int rt=k-1; rt<n; rt++){
            HashSet<Integer> salesType = new HashSet<>();
            for(int i = lt; i<=rt; i++){
                salesType.add(sales[i]);
            }
            lt++;
            answer.add(salesType.size());
        }
        return answer;
    }
}

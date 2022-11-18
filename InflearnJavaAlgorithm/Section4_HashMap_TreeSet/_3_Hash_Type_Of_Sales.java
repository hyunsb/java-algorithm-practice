package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.*;

public class _3_Hash_Type_Of_Sales {
    public static void main(String[] args) {
        _3_Hash_Type_Of_Sales T = new _3_Hash_Type_Of_Sales();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sales = new int[n];
        for(int i=0; i<n; i++) sales[i] = sc.nextInt();

        for(int salesType : T.solution(n, k, sales)) System.out.print(salesType + " ");
        for(int salesType : T.solution2(n, k, sales)) System.out.print(salesType + " ");
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

    public List<Integer> solution2(int n, int k, int[] sales){
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> salesType = new HashMap<>();

        for(int i=0; i<k-1; i++)
            salesType.put(sales[i], salesType.getOrDefault(sales[i], 0) + 1);

        int lt=0;
        for(int rt=k-1; rt<n; rt++){
            salesType.put(sales[rt], salesType.getOrDefault(sales[rt], 0) + 1);
            answer.add(salesType.size());
            salesType.put(sales[lt], salesType.get(sales[lt]) - 1);

            if(salesType.get(sales[lt]) == 0)
                salesType.remove(sales[lt]);

            lt++;
        }
        return answer;
    }
}

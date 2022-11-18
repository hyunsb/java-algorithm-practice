package InflearnJavaAlgorithm.Section4_HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class _1_Hash_Class_President {
    public char solution(int n, String voting){
        char answer = ' ';
        HashMap<Character, Integer> voteCount = new HashMap<>();

        for(char vote : voting.toCharArray()){
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(char key : voteCount.keySet()){
            if(voteCount.get(key) > max) {
                max = voteCount.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public char solution2(int n, String voting){
        HashMap<Character, Integer> voteCount = new HashMap<>();
        char classPresident = ' ';
        int maxValue = Integer.MIN_VALUE;

        for(char vote : voting.toCharArray()){
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) +1);

            int count = voteCount.get(vote);
            if(maxValue < count){
                maxValue = count;
                classPresident = vote;
            }
        }
        return classPresident;
    }

    public static void main(String[] args) {
        _1_Hash_Class_President T = new _1_Hash_Class_President();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String voting = sc.next();
        System.out.println(T.solution(n, voting));
        System.out.println(T.solution2(n, voting));
    }
}

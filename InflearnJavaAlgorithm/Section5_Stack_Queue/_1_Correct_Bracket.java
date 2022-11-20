package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class _1_Correct_Bracket {
    // 인프런 5-1 올바른 괄호
    public static void main(String[] args) {
        _1_Correct_Bracket T = new _1_Correct_Bracket();
        Scanner sc = new Scanner(System.in);

        String brackets = sc.nextLine();
        System.out.println(T.solution(brackets));
    }

    public String solution(String brackets){
        int count = 0;
        for(char bracket : brackets.toCharArray()){
            count += (bracket == '(') ? 1 : -1;
            if(count < 0)
                return "NO";
        }

        return (count==0) ? "YES" : "NO";
    }
}

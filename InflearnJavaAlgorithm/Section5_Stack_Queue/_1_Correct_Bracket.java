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
        System.out.println(T.solution2(brackets));
    }

    public String solution2(String brackets){
        Stack<Character> bracketStack = new Stack<>();
        for(char bracket : brackets.toCharArray()){
            if(bracket == '(') bracketStack.add(bracket);
            else {
                if(bracketStack.isEmpty())return "NO";
                bracketStack.pop();
            }
        }
        if(!bracketStack.isEmpty()) return "NO";
        return "YES";
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

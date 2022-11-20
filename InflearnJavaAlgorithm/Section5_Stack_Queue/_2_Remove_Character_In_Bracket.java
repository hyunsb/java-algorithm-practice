package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class _2_Remove_Character_In_Bracket {
    // 인프런 5-2 괄호문자제거
    public static void main(String[] args) {
        _2_Remove_Character_In_Bracket T = new _2_Remove_Character_In_Bracket();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }


    public String solution(String str){
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == ')'){
                while (true){
                    int pop = stack.pop();
                    if (pop == '(') break;
                }
            }else {
                stack.add(c);
            }
        }
        for(char c : stack) answer.append(c);
        stack.clear();
        return answer.toString();
    }
}

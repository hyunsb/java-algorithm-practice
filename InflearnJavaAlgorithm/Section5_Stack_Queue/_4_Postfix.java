package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class _4_Postfix {
    public static void main(String[] args) {
        _4_Postfix T = new _4_Postfix();
        Scanner sc = new Scanner(System.in);
        String postfix = sc.nextLine();
        System.out.println(T.solution(postfix));
        System.out.println(T.solution2(postfix));
    }

    public int solution2(String postfix){
        Stack<Integer> stack = new Stack<>();
        for(char x  : postfix.toCharArray()){
            if(Character.isDigit(x)) stack.push(Character.getNumericValue(x));
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt+rt);
                if(x == '-') stack.push(lt-rt);
                if(x == '*') stack.push(lt*rt);
                if(x == '/') stack.push(lt/rt);
            }
        }
        return stack.pop();
    }

    public int solution(String postfix){
        Stack<Integer> stack = new Stack<>();
        for(char c : postfix.toCharArray()){
            int tmp = Character.getNumericValue(c);
            if(1 <= tmp && tmp <= 9) stack.push(tmp);
            else {
                int m = stack.pop();
                int n = stack.pop();
                switch (c) {
                    case '+' :
                        stack.push(n+m);
                        break;
                    case '-' :
                        stack.push(n-m);
                        break;
                    case '*' :
                        stack.push(n*m);
                        break;
                    case '/' :
                        stack.push(n/m);
                        break;
                }
            }
        }
        return stack.pop();
    }
}

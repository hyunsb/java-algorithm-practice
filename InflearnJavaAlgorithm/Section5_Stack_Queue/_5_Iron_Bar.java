package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class _5_Iron_Bar {
    public static void main(String[] args) {
        _5_Iron_Bar T = new _5_Iron_Bar();
        Scanner sc = new Scanner(System.in);
        String bar = sc.nextLine();
        System.out.println(T.solution(bar));
    }

    public int solution(String bar){
        int ironBarCnt = 0;
        int cuttingCnt = 0;
        Stack<Character> stack = new Stack<>();

        char tmp = ' ';
        for (char c : bar.toCharArray()){
            if(c == '(') {
                stack.push(c);
                ironBarCnt += 1;
            }
            else {
                stack.pop();
                if (tmp == '('){
                    cuttingCnt += stack.size();
                    ironBarCnt -= 1;
                }
            }
            tmp = c;
        }

        return ironBarCnt + cuttingCnt;
    }
}

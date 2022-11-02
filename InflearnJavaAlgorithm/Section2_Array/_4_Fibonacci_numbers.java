package InflearnJavaAlgorithm.Section2_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _4_Fibonacci_numbers {
    public List<Integer> solution(int num){
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<num; i++) answer.add((i < 2) ? 1 : answer.get(i-2) + answer.get(i-1));
        return answer;
    }

    public static void main(String[] args) {
        _4_Fibonacci_numbers T = new _4_Fibonacci_numbers();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int x : T.solution(num)) System.out.print(x + " ");
    }

}

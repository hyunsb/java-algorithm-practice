package inflearn.stack_queue._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] postfix = bufferedReader.readLine().split("");

        Stack<Integer> numbers = new Stack<>();
        for (String s : postfix) {
            try {
                numbers.push(Integer.parseInt(s));
            } catch (NumberFormatException exception) {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                switch (s) {
                    case "+" :
                        numbers.push(num2 + num1);
                        break;
                    case "-" :
                        numbers.push(num2 - num1);
                        break;
                    case "/" :
                        numbers.push(num2 / num1);
                        break;
                    case "*" :
                        numbers.push(num2 * num1);
                        break;
                }
            }
        }
        System.out.println(numbers.pop());
    }
}

package inflearn.stack_queue._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // (A(BC)D)EF(G(H)(IJ)K)LM(N)
        char[] words = bufferedReader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char word : words) {
            if (word == ')') {
                while (true) {
                    Character pop = stack.pop();
                    if (pop == '(') break;
                }
            } else {
                stack.push(word);
            }
        }
        stack.forEach(System.out::print);
    }
}

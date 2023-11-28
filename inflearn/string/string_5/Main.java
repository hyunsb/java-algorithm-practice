package inflearn.string.string_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(charArray[i])) {
                stringBuilder.append(stack.pop());
            } else {
                stringBuilder.append(charArray[i]);
            }
        }
        System.out.println(stringBuilder);
    }
}

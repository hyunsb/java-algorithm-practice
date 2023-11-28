package inflearn.string.string_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solutionB(input));
    }

    public static String solutionB(String word) {
        int left = 0;
        int right = word.length() - 1;

        char[] words = word.toCharArray();

        while (left < right) {
            if (!Character.isAlphabetic(words[left])) left += 1;
            if (!Character.isAlphabetic(words[right])) right -= 1;
            if (Character.isAlphabetic(words[left]) && Character.isAlphabetic(words[right])) {
                char temp = words[left];
                words[left] = words[right];
                words[right] = temp;

                left += 1;
                right -= 1;
            }
        }
        return String.valueOf(words);
    }

    public static String solutionA(String word) {
        Stack<Character> stack = new Stack<>();
        for (char c : word.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isAlphabetic(charArray[i])) {
                stringBuilder.append(stack.pop());
            } else {
                stringBuilder.append(charArray[i]);
            }
        }
        return stringBuilder.toString();
    }
}

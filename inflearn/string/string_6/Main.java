package inflearn.string.string_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solutionB(input));
    }

    private static String solutionB(String word) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.toCharArray().length; i++) {
            if (i == word.indexOf(word.charAt(i))) {
                stringBuilder.append(word.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static String solution(String word) {
        List<Character> alphabets = new ArrayList<>();
        for (char c : word.toCharArray()) {
            alphabets.add(c);
        }

        for (int left = 0; left < alphabets.size(); left++) {
            for (int right = alphabets.size() - 1; right > left ; right--) {
                if (alphabets.get(left).equals(alphabets.get(right))) {
                    alphabets.remove(right);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        alphabets.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}

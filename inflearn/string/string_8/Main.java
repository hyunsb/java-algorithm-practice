package inflearn.string.string_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input.toUpperCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stringBuilder.append(c);
            }
        }
        String word = stringBuilder.toString();
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }
}

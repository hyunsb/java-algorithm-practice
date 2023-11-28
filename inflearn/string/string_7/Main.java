package inflearn.string.string_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(input));
    }

    private static String solutionB(String input) {
        String reverseInput = new StringBuilder(input).reverse().toString();
        if (input.equals(reverseInput)) return "YES";
        return "NO";
    }

    private static String solution(String input) {
        String word = input.toUpperCase();
        for (int i = 0; i < word.length()/2; i++) {
            if (word.charAt(i) != word.charAt(word.length()-1-i)) {
                return "NO";
            }
        }
        return "YES";
    }
}

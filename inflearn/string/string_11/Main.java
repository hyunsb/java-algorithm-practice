package inflearn.string.string_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solutionB(input));
    }

    private static String solutionB(String input) {
        StringBuilder answer = new StringBuilder();

        int count = 1;
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) != input.charAt(i+1)) {
                answer.append(input.charAt(i));
                if (count > 1) answer.append(count);
                count = 1;
            } else {
                count += 1;
            }
        }
        return answer.toString();
    }

    private static String solution(String input) {
        StringBuilder answer = new StringBuilder();

        char target = ' ';
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            if (target != input.charAt(i)) {
                answer.append(target);
                if (count > 1) answer.append(count);
                count = 1;
                target = input.charAt(i);
            } else count += 1;

            if (i == input.length() - 1) {
                answer.append(target);
                if (count > 1) answer.append(count);
            }
        }
        return answer.toString().trim();
    }
}

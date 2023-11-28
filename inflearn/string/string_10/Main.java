package inflearn.string.string_10;

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

    private static String solutionB(String input) {
        String word = input.split(" ")[0];
        String alphabet = input.split(" ")[1];

        int distance = 1000;
        int[] count = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).equals(alphabet)) {
                distance = 0;
            } else distance += 1;
            count[i] = distance;
        }

        distance = 1000;
        for (int i = word.length()-1; i >= 0; i--) {
            if (String.valueOf(word.charAt(i)).equals(alphabet)) {
                distance = 0;
            } else distance += 1;
            count[i] = Math.min(count[i], distance);
        }

        String answer = "";
        for (int i : count) {
            if (answer.isEmpty())
                answer = String.valueOf(i);
            else answer = String.join(" ", answer, String.valueOf(i));
        }
        return answer;
    }

    private static String solution(String input) {
        String word = input.split(" ")[0];
        String alphabet = input.split(" ")[1];

        int[] count = new int[word.length()];

        List<Integer> alphabetIndex = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(input.charAt(i)).equals(alphabet)) {
                count[i] = 0;
                alphabetIndex.add(i);
            }
        }

        for (int i = 0; i < word.length(); i++) {
            int distance = Integer.MAX_VALUE;
            for (Integer index : alphabetIndex) {
                distance = Math.min(distance, Math.abs(i - index));
            }
            count[i] = distance;
        }

        String answer = "";
        for (int i : count) {
            if (answer.isEmpty())
                answer = String.valueOf(i);
            else answer = String.join(" ", answer, String.valueOf(i));
        }
        return answer;
    }
}

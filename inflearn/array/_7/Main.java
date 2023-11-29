package inflearn.array._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println(solution(bufferedReader.readLine().split(" ")));
    }

    private static int solution(String[] board) {
        int score = 0;
        int count = 0;
        for (String s : board) {
            if (s.equals("1")) score += ++count;
            else count = 0;
        }
        return score;
    }
}

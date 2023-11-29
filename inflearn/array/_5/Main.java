package inflearn.array._5;

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
        int n = Integer.parseInt(input);
        int count = 0;

        int[] board = new int[n+1];
        for (int i = 2; i < board.length; i++) {
            if (board[i] == 0) {
                count += 1;
                for (int j = i; j < board.length; j += i) {
                    board[j] = 1;
                }
            }
        }
        return String.valueOf(count);
    }
}

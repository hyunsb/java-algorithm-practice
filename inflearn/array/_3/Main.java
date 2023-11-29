package inflearn.array._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int n = Integer.parseInt(input);
        int[][] board = new int[2][n];

        for (int i = 0; i < 2; i++) {
            String[] numbers = bufferedReader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        System.out.println(solution(board));
    }

    private static String solution(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board[0].length; i++) {
            int a = board[0][i];
            int b = board[1][i];

            if (a == b) stringBuilder.append("D").append("\n");
            else if (a == 1 && b == 3) stringBuilder.append("A").append("\n");
            else if (a == 2 && b == 1) stringBuilder.append("A").append("\n");
            else if (a == 3 && b == 2) stringBuilder.append("A").append("\n");
            else stringBuilder.append("B").append("\n");
        }
        return stringBuilder.toString();
    }
}

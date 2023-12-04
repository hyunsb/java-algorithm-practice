package inflearn.array._9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(solution(arr));
    }

    private static int solution(int[][] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < arr.length; j++) {
                row += arr[i][j];
                col += arr[j][i];
            }
            answer = Math.max(answer, Math.max(row, col));
        }
        int rd = 0;
        int ld = 0;
        for (int i = 0; i < arr.length; i++) {
            rd += arr[i][i];
            ld += arr[i][arr.length - i - 1];
        }
        answer = Math.max(answer, Math.max(rd, ld));

        return answer;
    }
}

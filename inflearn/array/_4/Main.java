package inflearn.array._4;

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
        int number = Integer.parseInt(input);
        int[] fibonacci = new int[number];

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1 1 ");

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < number; i++) {
            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
            stringBuilder.append(fibonacci[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}

package inflearn.array._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] stringNumbers = bufferedReader.readLine().split(" ");
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }

        System.out.println(solution(n, numbers));
    }

    private static String solution(int n, int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) stringBuilder.append(numbers[i]).append(" ");
            else {
                if (numbers[i] > numbers[i-1])
                    stringBuilder.append(numbers[i]).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}

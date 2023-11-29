package inflearn.array._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        solution(bufferedReader.readLine().split(" "));
    }

    private static void solution(String[] numbers) {
        for (String stringNumber : numbers) {
            int number = Integer.parseInt(new StringBuilder(stringNumber).reverse().toString());
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;
        for (int i = 2; i < number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

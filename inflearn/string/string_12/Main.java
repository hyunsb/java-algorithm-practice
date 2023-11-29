package inflearn.string.string_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number = bufferedReader.readLine();
        String password = bufferedReader.readLine();

        System.out.println(solutionB(number, password));
    }

    private static String solutionB(String input1, String input2) {
        int number = Integer.parseInt(input1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            String password = input2.substring(0, 7).replace('#', '1').replace('*', '0');

            int decimalValue = Integer.parseInt(password, 2);
            stringBuilder.append((char) decimalValue);

            input2 = input2.substring(7);
        }
        return stringBuilder.toString();
    }

    private static String solution(String input1, String input2) {
        String password = input2;

        String answer = "";
        String binaryCode = "";
        for (int i = 1; i <= password.length(); i++) {

            char c = password.charAt(i - 1);
            if (c == '#') binaryCode += 1;
            else binaryCode += 0;

            if (i % 7 == 0) {
                int decimal = Integer.parseInt(binaryCode, 2);
                answer += (char) decimal;
                binaryCode = "";
            }
        }
        return answer;
    }
}

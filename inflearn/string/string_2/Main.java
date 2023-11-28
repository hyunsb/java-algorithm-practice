package inflearn.string.string_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                stringBuilder.append(Character.toUpperCase(c));
            }
        }
        System.out.println(stringBuilder);
    }
}

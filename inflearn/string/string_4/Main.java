package inflearn.string.string_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int count = Integer.parseInt(input);
        for (int i = 0; i < count; i++) {
            String word = bufferedReader.readLine();

            StringBuilder stringBuilder = new StringBuilder(word).reverse();
            System.out.println(stringBuilder);
        }
    }
}

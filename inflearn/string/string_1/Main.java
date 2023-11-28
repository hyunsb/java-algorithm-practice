package inflearn.string.string_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String alphabet = bufferedReader.readLine();

        int count = 0;
        for (String s : input.toUpperCase().split("")) {
            if (s.equals(alphabet.toUpperCase())) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}

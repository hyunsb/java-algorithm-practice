package inflearn.string.string_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        String[] strings = input.split(" ");
        int maxLength = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > maxLength) {
                maxLength = strings[i].length();
                index = i;
            }
        }
        System.out.println(strings[index]);
    }
}

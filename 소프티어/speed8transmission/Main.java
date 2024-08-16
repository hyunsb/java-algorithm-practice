package 소프티어.speed8transmission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] numbers = new int[8];
        for (int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String answer = "";
        int start = numbers[0];
        if (start == 1) {
            answer = "ascending";
        } else if (start == 8) {
            answer = "descending";
        } else {
            System.out.println("mixed");
            return;
        }

        for (int i = 1; i < 8; i++) {
            int first = numbers[i-1];
            int second = numbers[i];

            if (Math.abs(second - first) > 1) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println(answer);
    }
}

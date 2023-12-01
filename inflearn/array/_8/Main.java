package inflearn.array._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();

        String[] split = bufferedReader.readLine().split(" ");
        int[] scores = new int[split.length];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(split[i]);
        }

        for (int i = 0; i < scores.length; i++) {
            int rank = 1;
            for (int j = 0; j < scores.length; j++) {
                if (i == j) continue;
                if (scores[i] < scores[j]) {
                    rank += 1;
                }
            }
            System.out.print(rank + " ");
        }
    }
}

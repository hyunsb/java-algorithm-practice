import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static StringBuilder result = new StringBuilder();
    static int n;
    static int[] numbers;
    static boolean[] isVisit;
    static int[] current;

    public static void back(int start, int depth) {
        if (depth == 6) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : current) {
                stringBuilder.append(i).append(" ");
            }
            result.append(stringBuilder).append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                current[depth] = numbers[i];
                back(i, depth + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String read = bufferedReader.readLine();
            if (read.equals("0")) break;

            StringTokenizer tokenizer = new StringTokenizer(read);
            n = Integer.parseInt(tokenizer.nextToken());
            numbers = new int[n];
            isVisit = new boolean[n];
            current = new int[6];

            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }

            back(0, 0);
            result.append("\n");
        }
        System.out.println(result);
    }
}
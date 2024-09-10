package review.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

    static boolean[] isVisit;
    static int[] numbers;
    static StringBuilder answer = new StringBuilder();

    public static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int number : numbers) {
                answer.append(number).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                numbers[depth] = i + 1;
                dfs(n, m, depth + 1);
                isVisit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        isVisit = new boolean[n];
        numbers = new int[m];
        dfs(n, m, 0);
        System.out.println(answer);
    }
}

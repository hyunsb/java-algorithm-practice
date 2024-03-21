import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] numbers;
    static boolean[] isVisited;
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        numbers = new int[m];
        isVisited = new boolean[n+1];
        backTracking(0);
        System.out.println(builder);
    }

    private static void backTracking(int depth) {
        if (depth == m) {
            for (int number : numbers) {
                builder.append(number).append(" ");
            }
            builder.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                numbers[depth] = i;
                backTracking(depth+1);
                isVisited[i] = false;
            }
        }
    }
}
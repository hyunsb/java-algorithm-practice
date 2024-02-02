import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] arr;
    static int n, m;
    static StringBuilder answer = new StringBuilder();

    static void DFS(int start, int depth) {
        if (depth == m) {
            for (int i : arr) {
                answer.append(i).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            DFS(i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        arr = new int[m];
        DFS(1, 0);
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, s;
    static int[] numbers;
    static int count;

    public static void dfs(int sum, int idx) {
        if (idx == n) {
            if (sum == s) count+=1;
            return;
        }
        dfs(sum + numbers[idx], idx + 1);
        dfs(sum, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        count = 0;
        n = Integer.parseInt(tokenizer.nextToken());
        s = Integer.parseInt(tokenizer.nextToken());
        numbers = new int[n];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dfs(0, 0);
        System.out.println((s == 0) ? count - 1 : count);
    }
}
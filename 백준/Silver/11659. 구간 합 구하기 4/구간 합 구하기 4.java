import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] sumTable = new int[n + 1];

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            sum += number;
            sumTable[i] = sum;
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            System.out.println(sumTable[end] - sumTable[start - 1]);
        }
    }
}
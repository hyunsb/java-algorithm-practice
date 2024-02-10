import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int k = Integer.parseInt(tokenizer.nextToken());
        long n = Integer.parseInt(tokenizer.nextToken());
        long max = 1;
        long min = 1;
        int[] lines = new int[k];

        for (int i = 0; i < k; i++) {
            int line = Integer.parseInt(bufferedReader.readLine());
            lines[i] = line;
            if (max < line) max = line;
        }

        long length = 0;
        while (min <= max) {
            long mid = (min + max) / 2;

            long count = 0;
            for (int line : lines) {
                count += line/mid;
            }

            if (count < n) {
                max = mid - 1;
            } else {
                length = Math.max(length, mid);
                min = mid + 1;
            }
        }
        System.out.println(length);
    }
}
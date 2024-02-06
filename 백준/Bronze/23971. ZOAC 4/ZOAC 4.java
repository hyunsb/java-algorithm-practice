import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken()) + 1;
        int m = Integer.parseInt(tokenizer.nextToken()) + 1;

        int col = h/n;
        int row = w/m;
        if (h % n > 0) col += 1;
        if (w % m > 0) row += 1;

        System.out.println(col*row);
    }
}
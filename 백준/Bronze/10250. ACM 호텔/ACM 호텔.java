import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int loof = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        for (int i = 0; i < loof; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int h = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());

            int pre = (n % h == 0) ? 1 : n % h;
            int tempPost = n / h + 1;
            String post = (tempPost < 10) ? "0" + tempPost : String.valueOf(tempPost);

            if (n % h == 0) {
                System.out.println((h * 100) + (n/h));
            } else {
                System.out.println((n % h) * 100 + (n/h) + 1);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int h = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        if (m < 45) {
            if (h == 0) h = 23;
            else h -= 1;

            m = (60 - Math.abs(m - 45)) % 60;
        } else {
            m -= 45;
        }
        System.out.println(h + " " + m);
    }
}

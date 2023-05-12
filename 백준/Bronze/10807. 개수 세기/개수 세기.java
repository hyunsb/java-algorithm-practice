import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int roof = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int target = Integer.parseInt(bufferedReader.readLine());

        int cnt = 0;
        while (tokenizer.hasMoreTokens()) {
            if (Integer.parseInt(tokenizer.nextToken()) == target)
                cnt++;
        }
        System.out.println(cnt);
    }
}
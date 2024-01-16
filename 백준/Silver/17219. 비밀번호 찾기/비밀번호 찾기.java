import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Map<String, String> passwords = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            passwords.put(tokenizer.nextToken(), tokenizer.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            answer.append(passwords.get(bufferedReader.readLine())).append("\n");
        }
        System.out.println(answer);
    }
}
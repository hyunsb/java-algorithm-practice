import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        Map<String, Integer> held = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String number = tokenizer.nextToken();
            held.put(number, held.getOrDefault(number, 0) + 1);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String number = tokenizer.nextToken();
            stringBuilder.append(held.getOrDefault(number, 0)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
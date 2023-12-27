import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Set<String> checker = new HashSet<>();
        for (int i = 0; i < n; i++) {
            checker.add(bufferedReader.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (checker.contains(bufferedReader.readLine())) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        while (t-- > 0) {
            Set<Integer> nums = new HashSet<>();

            int n = Integer.parseInt(bufferedReader.readLine());
            tokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(tokenizer.nextToken()));
            }

            int m = Integer.parseInt(bufferedReader.readLine());
            tokenizer = new StringTokenizer(bufferedReader.readLine());

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (nums.contains(Integer.parseInt(tokenizer.nextToken()))) {
                    answer.append(1).append("\n");
                    continue;
                }
                answer.append(0).append("\n");
            }
            System.out.print(answer);
        }
    }
}
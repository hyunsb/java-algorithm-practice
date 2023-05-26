import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        HashSet<Integer> hashSet = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(tokenizer.nextToken()));
        }

        int M = Integer.parseInt(bufferedReader.readLine());
        tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int result = 0;
            if (hashSet.contains(Integer.parseInt(tokenizer.nextToken())))
                result = 1;
            System.out.println(result);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        List<String> sequence = new ArrayList<>();

        for (int i = 1; i < n+1; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            sequence.add(String.valueOf(queue.poll()));
        }

        String answer = "<" + String.join(", ", sequence) + ">";
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> queue = new PriorityQueue<>(Integer::compare);
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(bufferedReader.readLine()));
        }

        int count = 0;
        while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            count += sum;
            queue.offer(sum);
        }
        System.out.println(count);
    }
}
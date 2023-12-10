import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number == 0) {
                if (queue.isEmpty()) answer.append(0).append("\n");
                else answer.append(queue.poll()).append("\n");
            } else {
                queue.add(number);
            }
        }
        System.out.println(answer);
    }
}
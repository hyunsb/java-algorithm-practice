package inflearn.stack_queue._8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> priorityQueue = new LinkedList<>();
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(i);
            priorityQueue.add(Integer.parseInt(tokenizer.nextToken()));
        }

        int count = 0;
        while (!numbers.isEmpty()) {
            Integer priority = priorityQueue.poll();
            boolean flag = true;
            for (Integer integer : priorityQueue) {
                if (integer > priority) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += 1;
                if (Objects.equals(numbers.poll(), m)) {
                    break;
                }
            } else {
                priorityQueue.offer(priority);
                numbers.offer(numbers.poll());
            }
        }
        System.out.println(count);
    }
}

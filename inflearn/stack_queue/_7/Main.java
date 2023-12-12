package inflearn.stack_queue._7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String correct = bufferedReader.readLine();
        String mine = bufferedReader.readLine();
        Queue<Character> queue = new LinkedList<>();
        for (char c : correct.toCharArray()) {
            queue.offer(c);
        }
        String answer = "NO";
        for (char c : mine.toCharArray()) {
            if (queue.isEmpty()) {
                answer = "YES";
                break;
            }
            if (queue.peek() == c) {
                queue.poll();
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<String> deque;
        StringTokenizer tokenizer;

        int loof = Integer.parseInt(bufferedReader.readLine());

        while (loof-- > 0) {

            char[] commands = bufferedReader.readLine().toCharArray();
            int n = Integer.parseInt(bufferedReader.readLine());
            tokenizer = new StringTokenizer(bufferedReader.readLine(), "[],");

            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(tokenizer.nextToken());
            }
            AC(deque, commands);
        }
        System.out.println(answer);
    }

    private static void AC(ArrayDeque<String> deque, char[] commands) {
        boolean isRight = true;
        for (char command : commands) {
            if (command == 'R') {
                isRight = !isRight;
                continue;
            }

            if(isRight) {
                if(deque.pollFirst() == null) {
                    answer.append("error\n");
                    return;
                }
            }
            else {
                if(deque.pollLast() == null) {
                    answer.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<String> deque, boolean isRight) {
        answer.append('[');
        if(deque.size() > 0) {
            if(isRight) {
                answer.append(deque.pollFirst());
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollFirst());
                }
            }
            else {
                answer.append(deque.pollLast());
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollLast());
                }
            }
        }
        answer.append(']').append('\n');
    }
}

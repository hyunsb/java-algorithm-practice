import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque;
        StringTokenizer tokenizer;
        
        int loof = Integer.parseInt(bufferedReader.readLine());

        while (loof-- > 0) {
            
            char[] commands = bufferedReader.readLine().toCharArray();
            int n = Integer.parseInt(bufferedReader.readLine());
            tokenizer = new StringTokenizer(bufferedReader.readLine(), "[],");
            
            deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(tokenizer.nextToken()));
            }
            AC(deque, commands);
        }
        System.out.println(answer);
    }

    private static void AC(ArrayDeque<Integer> deque, char[] commands) {
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
                // 만약 반환 된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
                if(deque.pollLast() == null) {
                    answer.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        answer.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장

        if(deque.size() > 0) {	//만약 출력 할 원소가 한 개 이상일 경우

            if(isRight) {	// 정방향일경우

                answer.append(deque.pollFirst());	// 먼저 첫 번째 원소를 넘겨준다.

                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollFirst());
                }
            }
            else {	// 역방향일경우
                answer.append(deque.pollLast());	// 먼저 뒤에서부터 첫 번째 원소를 넘겨준다.

                // 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 뒤에서부터 하나씩 뽑아 넘긴다.
                while(!deque.isEmpty()) {
                    answer.append(',').append(deque.pollLast());
                }
            }
        }

        answer.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
    }
}

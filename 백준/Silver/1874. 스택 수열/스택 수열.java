import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        for (int repeat = 0; repeat < n; repeat++) {
            int target = Integer.parseInt(bufferedReader.readLine());
            while (target >= i) {
                stack.push(i++);
                answer.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                answer.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(answer);
    }
}
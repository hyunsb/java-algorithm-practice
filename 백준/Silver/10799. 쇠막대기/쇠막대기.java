import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char[] brackets = bufferedReader.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < brackets.length; i++) {
            char bracket = brackets[i];
            if (bracket == '(') {
                stack.add(bracket);
            } else {
                stack.pop();
                if (brackets[i - 1] == '(') answer += stack.size();
                else answer += 1;
            }
        }
        System.out.println(answer);
    }
}
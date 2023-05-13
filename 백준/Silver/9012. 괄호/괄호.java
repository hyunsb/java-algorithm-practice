import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {

            Stack<Character> ps = new Stack<>();
            String answer = "NO";
            boolean flag = true;

            for (Character c : bufferedReader.readLine().toCharArray()) {
                try {
                    Character character = (c == '(') ? ps.push(c) : ps.pop();
                } catch (EmptyStackException error) {
                    flag = false;
                    break;
                }
            }

            if (flag && ps.isEmpty()) answer = "YES";
            System.out.println(answer);
        }
    }
}

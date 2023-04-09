import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int repeatCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < repeatCount; i++) {
            String answer = "NO";
            boolean flag = true;
            String ps = bufferedReader.readLine();
            Stack<Character> psStack = new Stack<>();

            for(char parenthesis : ps.toCharArray()){
                if(parenthesis == '(') {
                    psStack.push(parenthesis);
                }else {
                    if(psStack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    else psStack.pop();
                }
            }
            if(flag && psStack.isEmpty()) answer = "YES";
            System.out.println(answer);
        }
    }
}
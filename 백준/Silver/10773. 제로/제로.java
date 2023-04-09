import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int repeatCount = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> accountBook = new Stack<>();

        for (int i = 0; i < repeatCount; i++) {
            int call = Integer.parseInt(bufferedReader.readLine());
            if ( call == 0) accountBook.pop();
            else accountBook.push(call);
        }

        int sum = 0;
        for (int i : accountBook )
            sum += i;

        System.out.println(sum);
    }
}
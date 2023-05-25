import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            char[] answer = bufferedReader.readLine().toCharArray();

            int cnt = 1;
            int score = 0;

            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == 'O') {
                    score += cnt++;
                } else {
                    cnt = 1;
                }
            }

            System.out.println(score);
        }
    }
}
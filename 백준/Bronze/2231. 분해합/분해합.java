import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int answer = 0;
        for (int i = 1; i < n; i++) {
            String[] temp = String.valueOf(i).split("");

            int sum = i;
            for (String num : temp) {
                sum += Integer.parseInt(num);
            }

            if (sum == n) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
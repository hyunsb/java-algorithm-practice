import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        while (true) {

            if ((n % 5) == 0) {
                count += n / 5;
                break;
            } else {
                count += 1;
                n -= 3;
            }

            if (n < 0) {
                count = -1;
                break;
            }
        }

        System.out.println(count);
    }
}
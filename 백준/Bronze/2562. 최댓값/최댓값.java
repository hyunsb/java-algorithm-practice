import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0, maxValue = Integer.MIN_VALUE;
        int cnt = 0;

        while (true) {
            try {
                int value = Integer.parseInt(bufferedReader.readLine());
                cnt++;
                if (maxValue < value) {
                    maxValue = value;
                    idx = cnt;
                }
            } catch (NumberFormatException exception) {
                break;
            }
        }

        System.out.println(maxValue + "\n" + idx);
    }
}
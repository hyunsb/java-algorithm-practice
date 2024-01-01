import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int l = Integer.parseInt(bufferedReader.readLine());

        int num = n * m * l;
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10] += 1;
            num /= 10;
        }

        for (int i : count) {
            System.out.println(i);
        }
    }
}

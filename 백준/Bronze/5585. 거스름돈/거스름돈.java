import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(bufferedReader.readLine());
        int[] coin = {500, 100, 50, 10, 5, 1};
        int n = coin.length;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += money / coin[i];
            money %= coin[i];
        }
        System.out.println(answer);
    }
}
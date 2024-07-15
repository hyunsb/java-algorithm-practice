import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(bufferedReader.readLine());
        
        int coin = Integer.MAX_VALUE;
        int max = money / 5;
        for (int i = max; i >= 0; i--) {
            int remainingMoney = money - (5 * i);
            if (remainingMoney % 2 != 0) {
                continue;
            }
            int currentCoin = i + (remainingMoney / 2);
            coin = Math.min(coin, currentCoin);
        }

        if (coin == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(coin);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }
        
        int count = 0;
        for (int i = coins.size() - 1; i >= 0; i--) {
            int coin = coins.get(i);

            if (money >= coin) {
                int tempCount = (money / coin);
                count += tempCount;
                money -= tempCount * coin;
            }
        }
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, k;
    static int[] amounts;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());
        long min = 1;
        long max = 0;
        amounts = new int[n];
        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(bufferedReader.readLine());
            amounts[i] = amount;
            if (max < amount) max = amount;
        }

        long maxAmount = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            
            if (getCount(mid)) {
                if (maxAmount < mid) maxAmount = mid;
                min = mid + 1;
                continue;
            }
            max = mid - 1;
        }
        System.out.println(maxAmount);
    }

    private static boolean getCount(long mid) {
        int count = 0;
        for (int amount : amounts) {
            count += amount / mid;
        }
        return count >= k;
    }
}
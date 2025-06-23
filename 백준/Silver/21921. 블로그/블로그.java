import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int[] nums = new int[n];

        int maxVisit = 0;
        int maxVisitCount = 0;

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += nums[i];
        }

        if (sum != 0) {
            maxVisit = sum;
            maxVisitCount += 1;
        }

        for (int i = x; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - x];

            if (sum > maxVisit) {
                maxVisit = sum;
                maxVisitCount = 1;
            } else if (sum == maxVisit) {
                maxVisitCount += 1;
            }
        }
        
        if (maxVisit == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(maxVisit);
        System.out.println(maxVisitCount);
    }
}
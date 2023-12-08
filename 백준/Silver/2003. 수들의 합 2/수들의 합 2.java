import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int p1 = 0, p2 = 0;
        int count = 0;
        while (p2 < n && p1 < n) {
            int sum = 0;
            for (int i = p1; i <= p2; i++) {
                sum += numbers[i];
            }

            if (sum == m) {
                count += 1;
                p1 += 1;
                p2 += 1;
            }
            else if (sum < m) p2 += 1;
            else p1 += 1;
        }
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());

        int start = 0;
        int end = 0;
        int length = Integer.MAX_VALUE;
        int sum = 0;
        while (start <= end && end <= n) {
            if (sum < s) {
                sum += numbers[end++];
            } else if (sum >= s) {
                length = Math.min(length, end - start);
                sum -= numbers[start++];
            }
        }
        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int x = Integer.parseInt(bufferedReader.readLine());
        int count = 0;

        int left = 0, right = n - 1;
        Arrays.sort(numbers);
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == x) {
                count += 1;
                left += 1;
                right -= 1;
            } else if (sum > x) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] fluid = new int[n];
        for (int i = 0; i < n; i++) {
            fluid[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer1 = 0, answer2 = 0;

        Arrays.sort(fluid);
        int left = 0, right = n - 1;
        int diff = Integer.MAX_VALUE;

        while (left < right) {
            int tempDiff = fluid[left] + fluid[right];

            if (Math.abs(tempDiff) < diff) {
                diff = Math.abs(tempDiff);
                answer1 = fluid[left];
                answer2 = fluid[right];
            }

            if (tempDiff > 0) {
                right -= 1;
            } else if (tempDiff < 0) {
                left += 1;
            } else {
                break;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
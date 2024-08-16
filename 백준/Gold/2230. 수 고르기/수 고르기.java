import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(numbers);

        int minGap = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < n) {
            int gap = numbers[right] - numbers[left];
            if (gap < m) {
                right += 1;
            } else if (gap > m) {
                minGap = Math.min(minGap, gap);
                left++;
            } else {
                minGap = gap;
                break;
            }
        }
        System.out.println(minGap);
    }
}
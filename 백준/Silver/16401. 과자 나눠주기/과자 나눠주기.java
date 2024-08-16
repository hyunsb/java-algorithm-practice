import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m, maxLength = 0;
    static int[] sticks;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        sticks = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            sticks[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(sticks); // O(n)

        int min = 1;
        int max = sticks[sticks.length - 1];
        while (min <= max) {
            int mid = (min + max) / 2;
            if (isPossible(mid)) {
                maxLength = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(maxLength);
    }

    private static boolean isPossible(int length) {
        int count = 0;
        for (int stick : sticks) {
            count += (stick / length);
            if (count >= m) return true;
        }
        return false;
    }
}
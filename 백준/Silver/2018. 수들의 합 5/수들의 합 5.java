import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());

        int answer = 1;

        int start = 1;
        int end = 1;
        int sum = 1;
        while (end != n) {

            if (sum == n) {
                answer += 1;
                sum -= start;
                start += 1;
            }

            if (sum > n) {
                sum -= start;
                start += 1;
            }

            if (sum < n) {
                end += 1;
                sum += end;
            }
        }

        System.out.println(answer);
    }
}
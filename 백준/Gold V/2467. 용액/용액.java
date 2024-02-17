import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[] fluids;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        fluids = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++)
            fluids[i] = Integer.parseInt(tokenizer.nextToken());

        int left = 0, right = n-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = fluids[left] + fluids[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = fluids[left];
                answer[1] = fluids[right];
            }

            if (sum >= 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
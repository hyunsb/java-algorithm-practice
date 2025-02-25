import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(numbers);

        StringBuilder answer = new StringBuilder();
        int m = Integer.parseInt(bufferedReader.readLine());
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            int current = Integer.parseInt(tokenizer.nextToken());

            if (isExist(current)) {
                answer.append(1).append("\n");
            } else {
                answer.append(0).append("\n");
            }
        }

        System.out.println(answer);
    }

    private static boolean isExist(int current) {
        if (current < numbers[0] || current > numbers[numbers.length - 1]) {
            return false;
        }

        int min = 0, max = numbers.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            
            int midNumber = numbers[mid];
            if (midNumber == current) return true;

            if (midNumber > current) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
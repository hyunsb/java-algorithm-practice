import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int lt = 0, rt = arr.length-1, answer = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (sum == M) {
                answer++;
                lt++;
            } else if (sum < M) {
                lt++;
            } else {
                rt--;
            }
        }

        System.out.println(answer);
    }
}
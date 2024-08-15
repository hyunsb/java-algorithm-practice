import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] arr = new int[2][n];

        StringTokenizer tokenizer;
        for (int i = 0; i < 2; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
               arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = arr[0][i];
            B[i] = arr[1][i];
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (A[i] * B[i]);
        }
        System.out.println(answer);
    }
}
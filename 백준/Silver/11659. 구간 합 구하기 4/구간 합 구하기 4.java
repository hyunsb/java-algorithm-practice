import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] sumArr = arr.clone();
        for (int i = 2; i < sumArr.length; i++) {
            sumArr[i] += sumArr[i-1];
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            int sum = sumArr[end] - sumArr[start-1];

            answer.append(sum).append("\n");
        }

        System.out.println(answer);
    }
}
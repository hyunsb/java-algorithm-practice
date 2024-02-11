import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int budget;
    static int[] requests;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        requests = new int[n];

        int sumOfRequests = 0;
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int request = Integer.parseInt(tokenizer.nextToken());
            requests[i] = request;
            sumOfRequests += request;
        }
        Arrays.sort(requests);
        budget = Integer.parseInt(bufferedReader.readLine());

        if (budget >= sumOfRequests) {
            System.out.println(requests[n-1]);
            return;
        }

        int answer = 0;
        int max = requests[n-1];
        int min = 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (isAvailable(mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static boolean isAvailable(int amount) {
        int sum = 0;
        for (int request : requests) {
            sum += Math.min(request, amount);
        }
        return sum <= budget;
    }
}
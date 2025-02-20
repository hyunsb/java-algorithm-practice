import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Queue<Integer> upperOne = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> lowerZero = new PriorityQueue<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());

            if (num == 0) { zeroCount+=1; }
            else if (num == 1) { oneCount+=1; }
            else if (num > 1) { upperOne.offer(num); }
            else if (num < 0) { lowerZero.offer(num); }
        }

        int answer = oneCount;

        while (upperOne.size() > 1) {
            answer += upperOne.poll() * upperOne.poll();;
        }
        if (!upperOne.isEmpty()) {
            answer += upperOne.poll();
        }

        while (lowerZero.size() > 1) {
            answer += lowerZero.poll() * lowerZero.poll();;
        }
        if (!lowerZero.isEmpty()) {
            if (zeroCount == 0) {
                answer += lowerZero.poll();
            }
        }

        System.out.println(answer);
    }
}
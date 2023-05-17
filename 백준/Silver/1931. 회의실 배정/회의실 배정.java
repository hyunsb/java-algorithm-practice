import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            pq.add(new Schedule(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }

        int end = 0, cnt = 0;
        while (!pq.isEmpty()) {
            Schedule schedule = pq.poll();

            if (schedule.start >= end) {
                cnt++;
                end = schedule.end;
            }
        }

        System.out.println(cnt);
    }

    private static class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            return (end == o.end) ? start - o.start : end - o.end;
        }
    }
}
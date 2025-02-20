import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer st;
        Queue<Meeting> meetings = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.offer(new Meeting(start, end));
        }

        int count = 1;
        int prevEnd = meetings.poll().end;
        
        while (!meetings.isEmpty()) {
            Meeting currentMeeting = meetings.poll();
            if (prevEnd <= currentMeeting.start) {
                count += 1;
                prevEnd = currentMeeting.end;
            }
        }
        System.out.println(count);
    }

    private static class Meeting implements Comparable<Meeting> {

        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting that) {
            if (this.end == that.end) return this.start - that.start;
            return this.end - that.end;
        }
    }
}
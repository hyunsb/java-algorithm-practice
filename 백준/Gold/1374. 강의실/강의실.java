import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;
    static List<Meeting> meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(tokenizer.nextToken());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            meetings.add(new Meeting(start, end));
        }

        meetings.sort(Meeting::compareTo);

        Queue<Integer> ends = new PriorityQueue<>(Integer::compareTo);
        ends.offer(meetings.get(0).end);
        int count = 1;
    
        for (int i = 1; i < meetings.size(); i++) {
            Meeting current = meetings.get(i);

            if (ends.peek() > current.start) {
                count += 1;
            } else {
                ends.poll();
            }
            ends.offer(current.end);
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
            if (this.start == that.start) {
                return this.end - that.end;
            }
            return this.start - that.start;
        }
    }
}
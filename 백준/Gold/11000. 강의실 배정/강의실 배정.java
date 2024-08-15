import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Study> studies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            studies.add(new Study(start, end));
        }

        studies.sort(Study::compareTo);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(0);
        
        for (int i = 0; i < studies.size(); i++) {
            Study currentStudy = studies.get(i);
            if (queue.peek() <= currentStudy.start) {
                queue.poll();
            }
            queue.add(currentStudy.end);
        }

        System.out.println(queue.size());
    }

    private static class Study implements Comparable<Study> {
        int start, end;

        public Study(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Study that) {
            if (this.start == that.start) {
                return this.end - that.end;
            }
            return this.start - that.start;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Problem> problems = new ArrayList<>();

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int deadLine = Integer.parseInt(tokenizer.nextToken());
            int score = Integer.parseInt(tokenizer.nextToken());

            problems.add(new Problem(deadLine, score));
        }
        problems.sort(Problem::compareTo);

        Queue<Integer> queue = new PriorityQueue<>();
        for (Problem problem : problems) {
            queue.offer(problem.score);

            if (queue.size() > problem.deadLine) {
                queue.poll();
            }
        }

        int answer = 0;
        while (!queue.isEmpty()){
            answer += queue.poll();
        }
        System.out.println(answer);
    }

    private static class Problem implements Comparable<Problem> {

        int deadLine, score;

        public Problem(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }

        @Override
        public int compareTo(Problem that) {
            return this.deadLine - that.deadLine;
        }
    }
}
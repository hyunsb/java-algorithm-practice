import java.io.*;
import java.util.*;

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

        // 데드라인 오름차순 정렬
        problems.sort(Comparator.comparingInt(p -> p.deadLine));

        // 점수 기준 최소 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Problem p : problems) {
            pq.offer(p.score);
            // 데드라인보다 푼 문제 수가 많으면 점수 낮은 것 제거
            if (pq.size() > p.deadLine) {
                pq.poll();  // 가장 점수 낮은 문제 제거
            }
        }

        // 총 점수 계산
        int totalScore = 0;
        while (!pq.isEmpty()) {
            totalScore += pq.poll();
        }

        System.out.println(totalScore);
    }

    private static class Problem {
        int deadLine, score;

        public Problem(int deadLine, int score) {
            this.deadLine = deadLine;
            this.score = score;
        }
    }
}

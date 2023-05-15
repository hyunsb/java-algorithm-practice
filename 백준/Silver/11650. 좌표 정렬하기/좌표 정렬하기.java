import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            pq.add(new Point(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
        }
        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()){
            Point point = pq.poll();
            builder.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(builder);
    }

    private static class Point implements Comparable<Point>{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return (x==o.x) ? y - o.y : x - o.x;
        }
    }
}

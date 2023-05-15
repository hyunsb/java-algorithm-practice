import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Point[] arr = new Point[N];
        StringTokenizer tokenizer;

        for (int i = 0; i < arr.length; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr);

        for (Point point : arr) {
            System.out.println(point);
        }
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x)
                return y - o.y;
            return x - o.x;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
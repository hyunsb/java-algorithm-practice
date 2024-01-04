import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int b = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][m];
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                int target = Integer.parseInt(tokenizer.nextToken());
                map[i][j] = target;
                if (target > maxH) maxH = target;
                if (target < minH) minH = target;
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for (int h = minH; h <= maxH; h++) {

            int block = b;
            int timeCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int targetH = map[i][j];
                    if (targetH == h) continue;

                    int temp = Math.abs(targetH - h);
                    if (targetH > h) {
                        block += temp;
                        timeCount += (temp * 2);
                    } else {
                        block -= temp;
                        timeCount += temp;
                    }
                }
            }

            if (block < 0) continue;
            if (time >= timeCount) {
                time = timeCount;
                high = h;
            }
        }
        System.out.println(time + " " + high);
    }
}
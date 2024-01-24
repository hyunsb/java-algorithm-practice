import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[][] map;
    static int INF = 10_000_000;

    private static void Floyd() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {

                    int middleK = map[i][k] + map[k][j];
                    if (middleK < map[i][j]) {
                        map[i][j] = middleK;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());

        map = new int[n+1][n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = INF;
                if (i == j) map[i][j] = 0;
            }
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            if (weight < map[start][end]) map[start][end] = weight;
        }

        Floyd();
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] == INF) map[i][j] = 0;
                answer.append(map[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
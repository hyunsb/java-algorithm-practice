import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Integer> counts = new PriorityQueue<>();
    static int numberCount;
    static int count;

    public static void DFS(int x, int y) {
        numberCount += 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + mx[i];
            int ny = y + my[i];

            try {
                if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    DFS(nx, ny);
                }
            } catch (ArrayIndexOutOfBoundsException ignored) { }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        map = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] numbers = bufferedReader.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    numberCount = 0;
                    isVisited[i][j] = true;
                    DFS(i, j);
                    counts.add(numberCount);
                }
            }
        }

        System.out.println(counts.size());
        while (!counts.isEmpty()) {
            System.out.println(counts.poll());
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][][] isVisited;

    private static int BFS() {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1, false));
        isVisited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            if (cx == n-1 && cy == m-1) return current.distance;

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];
                int nd = current.distance + 1;

                try {
                    if (map[nx][ny] == 0) {
                        if (!current.isBrokeWall) {
                            if (isVisited[0][nx][ny]) continue;
                            isVisited[0][nx][ny] = true;
                            queue.add(new Location(nx, ny, nd, false));
                        } else {
                            if (isVisited[1][nx][ny]) continue;
                            isVisited[1][nx][ny] = true;
                            queue.add(new Location(nx, ny, nd, true));
                        }
                    } else {
                        if (current.isBrokeWall) continue;
                        isVisited[1][nx][ny] = true;
                        queue.add(new Location(nx, ny, nd, true));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
        return -1;
    }

    private static class Location {
        int x;
        int y;
        int distance;
        boolean isBrokeWall;

        public Location(int x, int y, int distance, boolean isBreakWall) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBrokeWall = isBreakWall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        isVisited = new boolean[2][n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] numbers = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        System.out.println(BFS());
    }
}
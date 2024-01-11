import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    static int[][] map;
    static Queue<Tomato> queue = new LinkedList<>();
    static int minDay = 0;

    private static void BFS() {
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            minDay = current.day;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + mx[i];
                int ny = current.y + my[i];
                try {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        queue.add(new Tomato(nx, ny, current.day + 1));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        map = new int[m][n];
        boolean isAllRipen = true;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int tomato = Integer.parseInt(tokenizer.nextToken());
                if (tomato == 0) isAllRipen = false;
                if (tomato == 1) queue.add(new Tomato(i, j, 0));
                map[i][j] = tomato;
            }
        }

        if (isAllRipen) {
            System.out.println(0);
            return;
        }
        BFS();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(minDay);
    }
}
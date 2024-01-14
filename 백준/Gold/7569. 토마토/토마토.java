import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] mx = {1, -1, 0, 0, 0, 0};
    static int[] my = {0, 0, 1, -1, 0, 0};
    static int[] mz = {0, 0, 0, 0, 1, -1};

    static int[][][] box;
    static Queue<Tomato> queue = new LinkedList<>();
    static int ripeDate = 0;

    private static void BFS() {
        while (!queue.isEmpty()) {
            Tomato currentTomato = queue.poll();
            ripeDate = currentTomato.date;

            for (int i = 0; i < 6; i++) {
                int nx = currentTomato.x + mx[i];
                int ny = currentTomato.y + my[i];
                int nz = currentTomato.z + mz[i];
                int nd = currentTomato.date + 1;

                try {
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = nd;
                        queue.add(new Tomato(nx, ny, nz, nd));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
        int z;
        int date;

        public Tomato(int x, int y, int z, int date) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", date=" + date +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int h = Integer.parseInt(tokenizer.nextToken());

        box = new int[h][m][n];

        boolean isAllRipe = true;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int x = 0; x < n; x++) {
                    int tomatoState = Integer.parseInt(tokenizer.nextToken());
                    if (isAllRipe && tomatoState == 0) isAllRipe = false;
                    if (tomatoState == 1) queue.add(new Tomato(x, y, z, 0));
                    box[z][y][x] = tomatoState;
                }
            }
        }

        if (isAllRipe) {
            System.out.println(0);
            return;
        }

        BFS();

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (box[z][y][x] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(ripeDate);
    }
}
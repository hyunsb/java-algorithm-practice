import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    
    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};
    
    static int n, m;
    static String[][] map;
    static boolean[][] isVisited;
    static Queue<Position> queue = new LinkedList<>();
    static int meet;

    static String me = "I";
    static String wall = "X";
    static String person = "P";

    private static void BFS() {
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            if (person.equals(map[cx][cy])) {
                meet += 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];

                try {
                    if (!wall.equals(map[nx][ny]) && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        queue.add(new Position(nx, ny));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        
        map = new String[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = bufferedReader.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (me.equals(map[i][j])) {
                    queue.add(new Position(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        BFS();
        if (meet == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(meet);
    }
}
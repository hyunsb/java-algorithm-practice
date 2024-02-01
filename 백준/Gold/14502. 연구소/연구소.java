import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m;
    static int[][] originMap;
    static int maxSafeZoneSize = Integer.MIN_VALUE;
    static List<Location> disease;

    static int[] mx = {1, -1, 0, 0};
    static int[] my = {0, 0, 1, -1};

    private static void buildWall(int count) {
        if (count == 3) {
            inflection();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    buildWall(count + 1);
                    originMap[i][j] = 0;
                }
            }
        }
    }

    private static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void inflection() {
        Queue<Location> queue = new LinkedList<>(disease);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.copyOf(originMap[i], m);
        }

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + mx[i];
                int ny = cy + my[i];

                try {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 2;
                        queue.add(new Location(nx, ny));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) { }
            }
        }
        int safeZone = findSafeZone(map);
        if (safeZone > maxSafeZoneSize) maxSafeZoneSize = safeZone;
    }

    private static int findSafeZone(int[][] map) {
        int safeZoneCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    safeZoneCount += 1;
                }
            }
        }
        return safeZoneCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        originMap = new int[n][m];
        disease = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                int target = Integer.parseInt(tokenizer.nextToken());
                originMap[i][j] = target;
                if (target == 2) disease.add(new Location(i, j));
            }
        }

        buildWall(0);
        System.out.println(maxSafeZoneSize);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] parents;
    static Enemy[] enemies;

    private static class Enemy {
        int x, y, r;

        public Enemy(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean isInRound(Enemy enemy) {
            double distance = this.calcDistanceFrom(enemy);
            int radius = this.r + enemy.r;
            return radius >= distance;
        }

        private double calcDistanceFrom(Enemy that) {
            double x = Math.pow(this.x - that.x, 2);
            double y = Math.pow(this.y - that.y, 2);
            return Math.sqrt(x + y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bufferedReader.readLine());

        while (TC-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());

            enemies = new Enemy[n+1];
            parents = new int[n+1];
            for (int i = 0; i < n + 1; i++) {
                parents[i] = i;
            }

            StringTokenizer tokenizer;
            for (int i = 1; i < n+1; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                int r = Integer.parseInt(tokenizer.nextToken());

                enemies[i] = new Enemy(x, y, r);
            }

            for (int i = 1; i < n+1; i++) {
                for (int j = i+1; j < n+1; j++) {
                    if (enemies[i].isInRound(enemies[j])) {
                        union(i, j);
                    }
                }
            }
            System.out.println(getGroup(n));
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parents[x] = y;
    }

    private static int getGroup(int n) {
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            parents[i] = find(i);
        }

        Arrays.sort(parents);

        int pre = 0;
        for (int i = 1; i < n + 1; i++) {
            if (pre != parents[i]) {
                pre = parents[i];
                count += 1;
            }
        }
        return count;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        parents = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            if (command == 0) {
                union(x, y);
            } else {
                System.out.println((find(x) == find(y) ? "YES" : "NO"));
            }
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) parents[fx] = fy;
    }
}
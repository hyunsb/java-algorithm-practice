import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cityNumber = Integer.parseInt(bufferedReader.readLine());
        int travelNumber = Integer.parseInt(bufferedReader.readLine());

        parent = new int[cityNumber+1];
        for (int i = 0; i < cityNumber + 1; i++) {
            parent[i] = i;
        }

        StringTokenizer tokenizer;
        for (int i = 1; i < cityNumber+1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < cityNumber+1; j++) {
                int connect = Integer.parseInt(tokenizer.nextToken());
                if (connect == 1) {
                    union(i, j);
                }
            }
        }

        String[] travelRoute = bufferedReader.readLine().split(" ");
        for (int i = 1; i < travelNumber; i++) {
            int from = Integer.parseInt(travelRoute[i-1]);
            int to = Integer.parseInt(travelRoute[i]);

            if (find(from) != find(to)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) parent[fx] = fy;
    }
}
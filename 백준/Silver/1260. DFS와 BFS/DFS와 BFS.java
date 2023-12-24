import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[][] map;
    static boolean[] isVisited;

    static StringBuilder dfsAnswer = new StringBuilder();
    static StringBuilder bfsAnswer = new StringBuilder();

    static int n, m;

    public static void dfs(int value) {
        dfsAnswer.append(value).append(" ");
        isVisited[value] = true;

        for (int i = 1; i <= n; i++) {
            if (map[value][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int value) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[value] = true;
        queue.add(value);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsAnswer.append(current).append(" ");

            for (int i = 0; i <= n; i++) {
                if (map[current][i] == 1 && !isVisited[i]) {
                    queue.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());

        map = new int[n+1][n+1];
        isVisited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int edge1 = Integer.parseInt(tokenizer.nextToken());
            int edge2 = Integer.parseInt(tokenizer.nextToken());

            map[edge1][edge2] = map[edge2][edge1] = 1;
        }

        dfs(start);
        isVisited = new boolean[n+1];
        bfs(start);

        System.out.println(dfsAnswer);
        System.out.println(bfsAnswer);
    }
}
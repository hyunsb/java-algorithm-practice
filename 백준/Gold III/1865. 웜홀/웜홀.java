import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m, w;
    static List<Road>[] map;
    static int[] minDistance;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        for (int repeat = 0; repeat < TC; repeat++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            w = Integer.parseInt(tokenizer.nextToken());

            map = new ArrayList[n+1];
            minDistance = new int[n+1];
            for (int i = 0; i <= n; i++) {
                map[i] = new ArrayList<>();
            }

            for (int i = 0; i < m + w; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                if (i < m) {
                    map[start].add(new Road(end, weight));
                    map[end].add(new Road(start, weight));
                    continue;
                }
                map[start].add(new Road(end, -weight));
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= n; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    System.out.println("YES");
                    break;
                }
            }
            if (!isMinusCycle) {
                System.out.println("NO");
            }
        }
    }

    private static boolean bellmanFord(int start) {
        Arrays.fill(minDistance, INF);
        minDistance[start] = 0;
        boolean update = false;

        for (int i = 1; i < n; i++) {
            update = false;

            for (int j = 1; j <= n; j++) {
                for (Road next : map[j]) {
                    int nw = minDistance[j] + next.weight;
                    if (minDistance[j] != INF && minDistance[next.end] > nw) {
                        minDistance[next.end] = nw;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= n; i++) {
                for (Road next : map[i]) {
                    if (minDistance[i] != INF &&
                        minDistance[next.end] > minDistance[i] + next.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static class Road {
        int end;
        int weight;

        public Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
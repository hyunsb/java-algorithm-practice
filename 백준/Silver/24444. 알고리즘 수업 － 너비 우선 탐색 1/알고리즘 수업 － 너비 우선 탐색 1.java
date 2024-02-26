import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static ArrayList<Integer>[] map;
    static int[] visitNumber;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int startVertex = Integer.parseInt(tokenizer.nextToken());

        map = new ArrayList[n+1];
        visitNumber = new int[n+1];
        isVisited = new boolean[n+1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            map[start].add(end);
            map[end].add(start);
        }

        for (int i = 0; i < n + 1; i++) {
            map[i].sort(Integer::compareTo);
        }

        DFS(startVertex);
        for (int i = 1; i < n + 1; i++) {
            System.out.println(visitNumber[i]);
        }
    }

    private static void DFS(int startVertex) {
        int visitCount = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (isVisited[current]) continue;;
            isVisited[current] = true;
            visitNumber[current] = visitCount++;

            for (Integer next : map[current]) {
                if (!isVisited[next]) {
                    queue.add(next);
                }
            }
        }
    }
}
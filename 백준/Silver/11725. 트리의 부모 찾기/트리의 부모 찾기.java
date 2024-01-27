import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Integer>[] map;
    static boolean[] isVisited;
    static int[] parents;

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer next : map[current]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    parents[next] = current;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        map = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            map[i] = new ArrayList<>();
        }
        isVisited = new boolean[n+1];
        parents = new int[n+1];

        StringTokenizer tokenizer;
        for (int i = 0; i < n-1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int edge1 = Integer.parseInt(tokenizer.nextToken());
            int edge2 = Integer.parseInt(tokenizer.nextToken());

            map[edge1].add(edge2);
            map[edge2].add(edge1);
        }

        BFS();
        StringBuilder answer = new StringBuilder();
        for (int i = 2; i < n+1; i++) {
            answer.append(parents[i]).append("\n");
        }
        System.out.println(answer);
    }
}
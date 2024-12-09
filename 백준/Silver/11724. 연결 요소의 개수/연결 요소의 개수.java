import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static List<Integer>[] array;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        isVisited = new boolean[n+1];
        array = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            array[start].add(end);
            array[end].add(start);
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (isVisited[i]) {
                continue;
            }
            answer += 1;
            DFS(i);
        }
        System.out.println(answer);
    }

    private static void DFS(int start) {
        if (isVisited[start]) {
            return;
        }

        isVisited[start] = true;
        for (Integer end : array[start]) {
            if (isVisited[end]) {
                continue;
            }
            DFS(end);
         }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static List<Integer>[] shorterMap;
    static List<Integer>[] longerMap;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        isVisited = new boolean[n + 1];
        shorterMap = new ArrayList[n + 1];
        longerMap = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            shorterMap[i] = new ArrayList();
            longerMap[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            shorterMap[start].add(end);
            longerMap[end].add(start);
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int shorterFriends = findFriends(i, shorterMap);
            int longerFriends = findFriends(i, longerMap);

            if (shorterFriends + longerFriends == n-1) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    private static int findFriends(int start, List<Integer>[] map) {
        Arrays.fill(isVisited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : map[current]) {
                if (isVisited[next]) continue;
                isVisited[next] = true;
                queue.add(next);
            }
        }

        int friends = 0;
        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i])
                friends += 1;
        }
        return friends;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int INF = 10001;
    static int n, range, road;
    static int[] items, minDistance;
    static boolean[] isVisited;
    static List<Position>[] map;

    private static class Position implements Comparable<Position> {
        int end, weight;

        public Position(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Position that) {
            return this.weight - that.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        range = Integer.parseInt(tokenizer.nextToken());
        road = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        minDistance = new int[n+1];
        items = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(tokenizer.nextToken());
        }
        isVisited = new boolean[n+1];


        map = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < road; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            map[start].add(new Position(end, weight));
            map[end].add(new Position(start, weight));
        }

        int answer = 0;
        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, dijkstra(i));
        }
        System.out.println(answer);
    }

    private static int dijkstra(int start) {
        Arrays.fill(minDistance, INF);
        Arrays.fill(isVisited, false);
        Queue<Position> queue = new PriorityQueue<>();
        
        minDistance[start] = 0;
        queue.add(new Position(start, 0));

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (isVisited[current.end]) continue;
            isVisited[current.end] = true;

            for (Position next : map[current.end]) {
                int nextWeight = current.weight + next.weight;
                if (nextWeight < minDistance[next.end]) {
                    minDistance[next.end] = nextWeight;
                    queue.add(new Position(next.end, nextWeight));
                }
            }
        }

        int itemValue = 0;
        for (int i = 0; i < minDistance.length; i++) {
            if (minDistance[i] <= range) 
                itemValue += items[i];
        }
        return itemValue;
    }
}
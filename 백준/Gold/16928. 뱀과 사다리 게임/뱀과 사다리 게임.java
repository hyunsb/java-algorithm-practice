import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] map = new int[101];
    static boolean[] isVisited = new boolean[101];

    public int BFS(int location) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(location, 0));
        isVisited[location] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();
            int currentLocation = current.getLocation();
            int currentCount = current.getCount();

            if (currentLocation == 100) {
                return currentCount;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = currentLocation + dice;
                if (next > 100 || isVisited[next]) continue;

                if (map[next] != 0) next = map[next];
                isVisited[next] = true;
                queue.add(new Location(next, currentCount + 1));
            }
        }
        return -1;
    };

    static class Location {
        private final int location;
        private final int count;

        public Location(int location, int count) {
            this.location = location;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public int getLocation() {
            return location;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken()) + Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            map[Integer.parseInt(tokenizer.nextToken())] = Integer.parseInt(tokenizer.nextToken());
        }
        Main main = new Main();
        System.out.println(main.BFS(1));
    }
}
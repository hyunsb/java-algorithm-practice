import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int su, si;
    static boolean[] isVisited;

    private static int BFS() {
        Queue<Subin> queue = new LinkedList<>();
        queue.add(new Subin(su, 0));
        isVisited[su] = true;

        while (!queue.isEmpty()) {
            Subin current = queue.poll();
            int cLocation = current.location;
            int cTime = current.time;
            if (cLocation == si) return cTime;

            addQueue(cLocation * 2, cTime + 1, queue);
            addQueue(cLocation + 1, cTime + 1, queue);
            addQueue(cLocation - 1, cTime + 1, queue);
        }
        return -1;
    }

    static void addQueue(int nextLocation, int nextTime, Queue<Subin> queue) {
        if (nextLocation >= 0 && nextLocation < 100001 && !isVisited[nextLocation]) {
            queue.add(new Subin(nextLocation, nextTime));
            isVisited[nextLocation] = true;
        }
    }

    static class Subin {
        int location;
        int time;

        public Subin(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        su = Integer.parseInt(tokenizer.nextToken());
        si = Integer.parseInt(tokenizer.nextToken());
        isVisited = new boolean[100001];

        System.out.println(BFS());
    }
}
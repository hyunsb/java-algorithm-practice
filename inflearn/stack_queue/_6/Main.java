package inflearn.stack_queue._6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        Queue<Integer> live = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            live.add(i + 1);
        }

        while (live.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                live.offer(live.poll());
            }
            live.poll();
        }
        System.out.println(live.poll());
    }
}

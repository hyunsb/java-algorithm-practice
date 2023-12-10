import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number != 0) {
                priorityQueue.add(number);
            } else {
                if (priorityQueue.isEmpty()) answer.append(0).append("\n");
                else answer.append(priorityQueue.poll()).append("\n");
            }
        }
        System.out.println(answer);
    }
}
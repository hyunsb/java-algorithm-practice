import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1 + o2 == 0) {
                return o1 > o2 ? 1 : -1;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            String operation = bufferedReader.readLine();

            if (Objects.equals(operation, "0")) {
                if (queue.isEmpty()) {
                    answer.append("0\n");
                } else {
                    answer.append(queue.poll()).append("\n");
                }

            } else {
                queue.offer(Integer.parseInt(operation));
            }
        }
        System.out.println(answer);
    }
}
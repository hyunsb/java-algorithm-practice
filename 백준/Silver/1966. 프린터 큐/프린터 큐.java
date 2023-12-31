import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer;
        int n, m;
        for (int i = 0; i < repeat; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(bufferedReader.readLine());
            Queue<Element> queue = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                queue.add(new Element(j, Integer.parseInt(tokenizer.nextToken())));
            }

            int count = 0;
            while (true) {
                boolean isPoll = true;
                Element target = queue.poll();
                for (Element element : queue) {
                    if (element.getPriority() > target.getPriority()) {
                        isPoll = false;
                        queue.add(target);
                        break;
                    }
                }

                if (isPoll) {
                    count += 1;
                    if (target.getNumber() == m) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static class Element {

        private final int number;
        private final int priority;

        public Element(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }

        public int getNumber() {
            return number;
        }

        public int getPriority() {
            return priority;
        }
    }
}
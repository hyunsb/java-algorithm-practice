import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        Gem[] gems = new Gem[n];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int price = Integer.parseInt(tokenizer.nextToken());
            gems[i] = new Gem(weight, price);
        }
        Arrays.sort(gems);

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(bags);

        long maxValue = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int bagIdx = 0, gemIdx = 0; bagIdx < k; bagIdx++) {
            while (gemIdx < n && gems[gemIdx].weight <= bags[bagIdx]) {
                queue.add(gems[gemIdx].price);
                gemIdx++;
            }

            if (!queue.isEmpty()) {
                maxValue += queue.poll();
            }
        }
        System.out.println(maxValue);
    }

    private static class Gem implements Comparable<Gem> {
        int weight;
        int price;

        public Gem(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Gem that) {
            if (this.weight == that.weight) {
                return that.price - this.price;
            }
            return this.weight - that.weight;
        }
    }
}
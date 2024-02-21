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

        int gemNumber = Integer.parseInt(tokenizer.nextToken());
        int bagNumber = Integer.parseInt(tokenizer.nextToken());
        Gem[] gems = new Gem[gemNumber];
        int[] bags = new int[bagNumber];

        for (int i = 0; i < gemNumber; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int price = Integer.parseInt(tokenizer.nextToken());

            gems[i] = new Gem(weight, price);
        }

        for (int i = 0; i < bagNumber; i++) {
            bags[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(gems);
        Arrays.sort(bags);

        long maxPrice = 0;
        Queue<Integer> gemPriceCanPutBag = new PriorityQueue<>(Comparator.reverseOrder());

        int gemIndex = 0;
        for (int bagIndex = 0; bagIndex < bagNumber; bagIndex++) {
            while (gemIndex < gemNumber && bags[bagIndex] >= gems[gemIndex].weight) {
                gemPriceCanPutBag.add(gems[gemIndex].price);
                gemIndex++;
            }

            if (!gemPriceCanPutBag.isEmpty()) {
                maxPrice += gemPriceCanPutBag.poll();
            }
        }
        System.out.println(maxPrice);
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] parents;
    static Road[] roads;

    private static class Road implements Comparable<Road> {
        int start, end, weight;

        public Road(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road that) {
            return this.weight - that.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int houseNumber = Integer.parseInt(tokenizer.nextToken());
            int roadNumber = Integer.parseInt(tokenizer.nextToken());

            if (houseNumber == 0 && roadNumber == 0)
                break;

            parents = new int[houseNumber];
            for (int i = 0; i < houseNumber; i++) {
                parents[i] = i;
            }

            roads = new Road[roadNumber];

            int fullCost = 0;
            for (int i = 0; i < roadNumber; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                fullCost += weight;
                roads[i] = new Road(start, end, weight);
            }
            Arrays.sort(roads);

            int minCost = 0;
            for (Road road : roads) {
                if (union(road.start, road.end)) {
                    minCost += road.weight;
                }
            }
            System.out.println(fullCost - minCost);
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        parents[x] = y;
        return true;
    }
}
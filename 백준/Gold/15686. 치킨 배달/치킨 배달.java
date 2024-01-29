import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static List<Building> chickens;
    static List<Building> houses;
    static boolean[] isOpen;
    static int totalChickenNumber;
    static int minDistance = Integer.MAX_VALUE;

    private static void combination(int count, int idx) {
        if (count == m) {
            // 거리 구해서 최소값 비교
            int totalDistance = 0;

            for (Building house : houses) {
                int min = 2501;

                for (int i = 0; i < totalChickenNumber; i++) {
                    if (isOpen[i]) {
                        int distance = house.getDistanceFrom(chickens.get(i));
                        if (distance < min) min = distance;
                    }
                }
                totalDistance += min;
            }
            if (totalDistance < minDistance) minDistance = totalDistance;
            return;
        }

        // 치킨 집 뽑기
        for (int i = idx; i < totalChickenNumber; i++) {
            isOpen[i] = true;
            combination(count + 1, i + 1);
            isOpen[i] = false;
        }
    }

    private static class Building {
        int x;
        int y;

        public Building(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistanceFrom(Building from) {
            return Math.abs(this.x - from.x) + Math.abs(this.y - from.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                int target = Integer.parseInt(tokenizer.nextToken());
                if (target == 0) continue;
                if (target == 1) houses.add(new Building(i, j));
                if (target == 2) chickens.add(new Building(i, j));
            }
        }

        totalChickenNumber = chickens.size();
        isOpen = new boolean[totalChickenNumber];
        combination(0, 0);
        System.out.println(minDistance);
    }
}
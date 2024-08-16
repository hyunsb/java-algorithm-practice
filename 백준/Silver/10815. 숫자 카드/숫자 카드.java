import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] cards, targets;
    static boolean[] hits;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        n = Integer.parseInt(bf.readLine());
        cards = new int[n];
        stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(cards);

        m = Integer.parseInt(bf.readLine());
        targets = new int[m];
        hits = new boolean[m];

        stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < m; i++) {
            hits[i] = isHitNumber(targets[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (boolean hit : hits) {
            if (hit) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder);
    }

    private static boolean isHitNumber(int number) {
        int min = 0;
        int max = cards.length-1;

        while (min <= max) {
            int mid = (min + max) / 2;
            int currentNumber = cards[mid];
            if (currentNumber == number) return true;

            if (currentNumber < number) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}
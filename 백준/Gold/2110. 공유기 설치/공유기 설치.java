import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(house);

        int min = 1;
        int max = house[n-1] - house[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;

            if (getCount(mid) < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    private static int getCount(int distance) {

        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];

            if (locate - lastLocate >= distance) {
                count += 1;
                lastLocate = locate;
            }
        }
        return count;
    }
}

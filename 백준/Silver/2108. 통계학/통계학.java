import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] arr = new int[n]; // 정렬할 배열
        Map<Integer, Integer> map = new HashMap<>(); // 개수를 카운트할 맵
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            sum += num;
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr);

        System.out.println(Math.round((double) sum / n));
        System.out.println(arr[(n/2)]);
        System.out.println(getMode(map));
        System.out.println(arr[n-1] - arr[0]);
    }

    private static int getMode(Map<Integer, Integer> map) {
        int max = Integer.MIN_VALUE;
        List<Integer> mode = new ArrayList<>();

        for (Integer value : map.values()) {
            if (value > max) max = value;
        }

        for (Integer integer : map.keySet()) {
            if (max == map.get(integer)) mode.add(integer);
        }

        if (mode.size() == 1) {
            return mode.get(0);
        }
        Collections.sort(mode);
        return mode.get(1);
    }
}

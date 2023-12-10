package inflearn.hashMap_treeSet._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[] arr = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Map<Integer, Integer> sales = new HashMap<>();
        for (int i = 0; i < k-1; i++) {
            sales.put(arr[i], sales.getOrDefault(arr[i], 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int start = 0, end = k - 1;
        while (end < n) {
            sales.put(arr[end], sales.getOrDefault(arr[end++], 0) + 1);
            stringBuilder.append(sales.size()).append(" ");

            sales.put(arr[start], sales.get(arr[start]) - 1);
            if (sales.get(arr[start]) == 0) {
                sales.remove(arr[start]);
            }
            start += 1;
        }
        System.out.println(stringBuilder);
    }
}

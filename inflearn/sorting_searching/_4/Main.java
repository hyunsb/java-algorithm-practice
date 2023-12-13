package inflearn.sorting_searching._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        Queue<Integer> LRU = new LinkedList<>();

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            Integer target = Integer.parseInt(tokenizer.nextToken());
            if (LRU.size() == n) {
                if (!LRU.contains(target)) {
                    LRU.poll();
                }
            }
            LRU.remove(target);
            LRU.add(target);
        }

        List<Integer> list = new ArrayList<>(LRU);
        Collections.reverse(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}

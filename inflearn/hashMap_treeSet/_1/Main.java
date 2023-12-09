package inflearn.hashMap_treeSet._1;

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
        String[] arr = bufferedReader.readLine().split("");

        Map<String, Integer> vote = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = arr[i];
            vote.put(name, vote.getOrDefault(name, 0) + 1);
        }

        int max = 0;
        String answer = "";
        for (String s : vote.keySet()) {
            if (vote.get(s) > max) {
                max = vote.get(s);
                answer = s;
            }
        }
        System.out.println(answer);
    }
}

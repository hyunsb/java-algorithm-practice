package inflearn.hashMap_treeSet._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String word1 = bufferedReader.readLine();
        String word2 = bufferedReader.readLine();

        Map<String, Integer> wordMap = new HashMap<>();

        String answer = "YES";
        for (String s : word1.split("")) wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
        for (String s : word2.split("")) {
            if (wordMap.containsKey(s)) {
                wordMap.put(s, wordMap.get(s) - 1);
            } else {
                answer = "NO";
                break;
            }
        }

        for (Integer value : wordMap.values()) {
            if (value != 0) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }
}

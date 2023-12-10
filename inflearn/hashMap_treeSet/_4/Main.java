package inflearn.hashMap_treeSet._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        int answer = 0;
        Map<String, Integer> checker = new HashMap<>();
        for (String str : t.split("")) {
            checker.put(str, checker.getOrDefault(str, 0) + 1);
        }

        int start = 0, end = t.length();
        while (end <= s.length()) {
            String target = s.substring(start, end);
            Map<String, Integer> temp = new HashMap<>(checker);

            for (String string : target.split("")) {
                if (!temp.containsKey(string)) break;
                temp.put(string, temp.get(string) - 1);
                if (temp.get(string) == 0) temp.remove(string);
            }

//            System.out.println(target + " " + temp);
            if (temp.isEmpty()) answer += 1;
            start += 1;
            end += 1;
        }
        System.out.println(answer);
    }
}

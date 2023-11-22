import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        Set<Character> set = new HashSet<>();
        for (char c : (str1 + str2).toCharArray()) {
           set.add(c);
        }
        Map<Character, Integer> map1 = toMap(str1);
        Map<Character, Integer> map2 = toMap(str2);

        int count = 0;
        for (Character c : set) {
            Integer i1 = map1.getOrDefault(c, 0);
            Integer i2 = map2.getOrDefault(c, 0);

            if (!i1.equals(i2)){
                count += Math.abs(i1 - i2);
            }
        }
        System.out.println(count);
    }

    public static Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}

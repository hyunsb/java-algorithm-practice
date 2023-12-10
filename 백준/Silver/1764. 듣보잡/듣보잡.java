import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n + m; i++) {
            String name = bufferedReader.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        Set<String> answer = new TreeSet<>();
        for (String s : map.keySet()) {
            if(map.get(s) > 1) {
                answer.add(s);
            }
        }
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }
}
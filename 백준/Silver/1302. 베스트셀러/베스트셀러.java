import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            count.put(name, count.getOrDefault(name, 0) + 1);
        }

        List<Integer> max = new ArrayList<>(count.values());
        max.sort(Collections.reverseOrder());
        int maxValue = max.get(0);

        List<String> answer = new ArrayList<>();
        for (String s : count.keySet()) {
            if (count.get(s) == maxValue) {
                answer.add(s);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}
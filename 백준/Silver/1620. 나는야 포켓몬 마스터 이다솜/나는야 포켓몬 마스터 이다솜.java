import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numberMap = new HashMap<>();

        int count = 1;
        for (int i = 0; i < n; i++) {
            String name = bufferedReader.readLine();
            nameMap.put(name, count);
            numberMap.put(count, name);
            count += 1;
        }

        for (int i = 0; i < m; i++) {
            String question = bufferedReader.readLine();
            try {
                System.out.println(numberMap.get(Integer.parseInt(question)));
            } catch (NumberFormatException exception) {
                System.out.println(nameMap.get(question));
            }
        }
    }
}
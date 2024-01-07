import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer tokenizer;
        Map<String, Integer> cloths;
        for (int i = 0; i < repeat; i++) {

            int n = Integer.parseInt(bufferedReader.readLine());
            cloths = new HashMap<>();
            for (int j = 0; j < n; j++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                tokenizer.nextToken();
                String category = tokenizer.nextToken();

                cloths.put(category, cloths.getOrDefault(category, 0) + 1);
            }

            int count = 1;
            for (Integer value : cloths.values()) {
                count *= (value + 1);
            }
            count -= 1;
            System.out.println(count);
        }
    }
}
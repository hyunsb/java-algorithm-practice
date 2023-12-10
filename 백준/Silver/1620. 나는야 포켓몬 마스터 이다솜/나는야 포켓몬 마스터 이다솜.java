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

        Map<String, String> map = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i);
            String name = bufferedReader.readLine();
            map.put(name, number);
            map.put(number, name);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(map.get(bufferedReader.readLine()));
        }
    }
}
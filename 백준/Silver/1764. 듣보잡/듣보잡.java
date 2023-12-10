import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> set = new HashSet<>();
        Set<String> answer = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(bufferedReader.readLine());
        }
        for (int i = 0; i < m; i++) {
            String name = bufferedReader.readLine();
            if (set.contains(name)) {
                answer.add(name);
            }
        }

        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            set.add(n % 42);
        }
        System.out.println(set.size());
    }
}
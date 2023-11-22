import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a'] += 1;
        }

        int count = 0;
        for (int i = 0; i < countA.length; i++) {
            if (countA[i] != countB[i]) {
                count += Math.abs(countA[i] - countB[i]);
            }
        }
        System.out.println(count);
    }
}

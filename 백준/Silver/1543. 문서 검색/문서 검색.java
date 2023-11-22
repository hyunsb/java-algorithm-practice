import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String doc = bufferedReader.readLine();
        String word = bufferedReader.readLine();

        int count = 0;
        int start = 0;
        for (int end = word.length(); end <= doc.length(); ) {
            String substring = doc.substring(start, end);

            if (substring.equals(word)) {
                count += 1;
                start += word.length();
                end += word.length();
            } else {
                start += 1;
                end += 1;
            }
        }
        System.out.println(count);
    }
}

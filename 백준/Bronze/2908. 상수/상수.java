import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        StringBuilder str1 = new StringBuilder(stringTokenizer.nextToken());
        StringBuilder str2 = new StringBuilder(stringTokenizer.nextToken());

        for (int i = 2; i >= 0; i--) {
            if (str1.charAt(i) > str2.charAt(i)){
                System.out.println(str1.reverse());
                break;
            }

            else if (str1.charAt(i) <  str2.charAt(i)) {
                System.out.println(str2.reverse());
                break;
            }
        }
    }
}
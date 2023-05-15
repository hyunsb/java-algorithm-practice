import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bufferedReader.readLine().split("");
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder builder = new StringBuilder();
        Arrays.stream(arr).forEach(builder::append);
        System.out.println(builder);
    }
}
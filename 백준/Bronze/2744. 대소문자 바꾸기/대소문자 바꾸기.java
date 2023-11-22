import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (char alphabet : input.toCharArray()) {
            stringBuilder.append(translator(alphabet));
        }

        System.out.println(stringBuilder);
    }

    public static char translator(char alphabet) {
        if (Character.isUpperCase(alphabet)) {
            return Character.toLowerCase(alphabet);
        }
        return Character.toUpperCase(alphabet);
    }
}
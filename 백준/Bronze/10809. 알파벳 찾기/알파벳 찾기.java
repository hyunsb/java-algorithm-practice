import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            stringBuilder.append(word.indexOf(i)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        int answer = 0;

        String[] split = word.split("-");
        for (int i = 0; i < split.length; i++) {
            int sum = calcSum(split[i]);

            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }

    private static int calcSum(String word) {
        String[] split = word.split("[+]");

        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}
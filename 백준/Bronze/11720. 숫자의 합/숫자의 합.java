import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int answer = 0;
        for (String s : bufferedReader.readLine().split("")) {
            answer += Integer.parseInt(s);
        }
        System.out.println(answer);
    }
}
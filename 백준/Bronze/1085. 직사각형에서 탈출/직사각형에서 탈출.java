import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int[] point = new int[tokenizer.countTokens()];
        for (int i = 0; i < point.length; i++)
            point[i] = Integer.parseInt(tokenizer.nextToken());

        int minX = Math.min(point[2] - point[0], point[0]);
        int minY = Math.min(point[3] - point[1], point[1]);

        System.out.println(Math.min(minX, minY));
    }
}
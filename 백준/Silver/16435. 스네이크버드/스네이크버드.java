import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;


        tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int fruits[] = new int[N];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(fruits);
        for (int i : fruits) {
            if (L >= i) L++;
        }

        System.out.println(L);
    }
}
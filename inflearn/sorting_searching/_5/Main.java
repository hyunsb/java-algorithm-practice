package inflearn.sorting_searching._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = n; i > 0; i--) {
            if (!set.add(Integer.parseInt(tokenizer.nextToken()))) {
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");
    }
}

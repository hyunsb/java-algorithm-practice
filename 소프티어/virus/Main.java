package 소프티어.virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long result = K;
        for (int i = 1; i <= N; i++) {
            result = (result * P) % 1000000007;
        }
        System.out.println(result);
    }
}

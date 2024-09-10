package 소프티어.AvarageOfScore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(b.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(b.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            // System.out.println(scores[i]);
        }


        while (K-- > 0) {
            st = new StringTokenizer(b.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;

            for (int i = start; i <= end; i++) {
                sum += scores[i];
            }

            double result = (double) sum / (end - start + 1);
            System.out.printf("%.2f", result);
            System.out.println();
        }
    }
}

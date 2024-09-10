package 소프티어.XMarksTheSpot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static char target = 'X';

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(bf.readLine());
        StringBuilder answer = new StringBuilder();

        while(repeat-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            String first = st.nextToken().toUpperCase();
            String second = st.nextToken().toUpperCase();

            int xIndex = first.indexOf(target);
            answer.append(second.charAt(xIndex));
        }
        System.out.println(answer);
    }

}

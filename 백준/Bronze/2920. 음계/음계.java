import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> ascending = new ArrayList<>();
        List<Integer> descending = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            ascending.add(i);
            descending.add(i);
        }
        Collections.reverse(descending);

        List<Integer> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 8; i++) {
            list.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        
        if (ascending.equals(list)) {
            System.out.println("ascending");
        } else if (descending.equals(list)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
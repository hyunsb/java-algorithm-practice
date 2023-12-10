import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Set<String> board = new HashSet<>();

        StringTokenizer stringTokenizer;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            String check = stringTokenizer.nextToken();

            if (check.equals("enter")) {
                board.add(name);
            } else {
                board.remove(name);
            }
        }
        
        List<String> sortedNames = new ArrayList<>(board);
        Collections.sort(sortedNames, Collections.reverseOrder());

        sortedNames.forEach(System.out::println);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> students = new ArrayList<>();

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int student = Integer.parseInt(stringTokenizer.nextToken());
            students.add(student);
        }

        students.sort(Integer::compareTo);

        int sum = students.get(2) - students.get(0);
        for (int i = 4; i < students.size(); i += 2) {
            sum += (students.get(i) - students.get(i - 1));
        }

        // start = 0, end = 2
        int minSum = sum;
        int start = 0;
        for (int end = 2; end < students.size()-1; end += 2) {
            sum -= (students.get(end) - students.get(start));
            sum -= (students.get(end + 2) - students.get(end + 1));
            sum += (students.get(start + 1) - students.get(start));
            sum += (students.get(end + 2) - students.get(end));

            minSum = Integer.min(minSum, sum);
            start = end;
        }

        System.out.println(minSum);
    }
}
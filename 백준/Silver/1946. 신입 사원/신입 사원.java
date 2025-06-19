import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int tc = Integer.parseInt(bufferedReader.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Person> persons = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int document = Integer.parseInt(stringTokenizer.nextToken());
                int interview = Integer.parseInt(stringTokenizer.nextToken());

                persons.add(new Person(document, interview));
            }

            persons.sort((p1, p2) -> {
                if (p1.document == p2.document) {
                    return p1.interview - p2.interview;
                }
                return p1.document - p2.document;
            });

            int minInterview = persons.get(0).interview;
            int count = 1;
            for (int i = 1; i < n; i++) {
                Person person = persons.get(i);

                if (person.interview < minInterview) {
                    count += 1;
                    minInterview = person.interview;
                }
            }

            System.out.println(count);
        }
    }

    private static class Person {
        int document, interview;

        public Person(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "document=" + document +
                    ", interview=" + interview +
                    '}';
        }
    }
}

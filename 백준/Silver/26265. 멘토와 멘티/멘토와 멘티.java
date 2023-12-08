import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            pairs.add(new Pair(stringTokenizer.nextToken(), stringTokenizer.nextToken()));
        }

        pairs.sort(Pair::compareTo);
        pairs.forEach(System.out::println);
    }

    private static class Pair implements Comparable<Pair> {

        private String mento;
        private String menti;

        public Pair(String mento, String menti) {
            this.mento = mento;
            this.menti = menti;
        }

        @Override
        public String toString() {
            return mento + " " + menti;
        }

        @Override
        public int compareTo(Pair target) {
            if (this.mento.compareTo(target.mento) > 0) {
                return 1;
            } else if (this.mento.compareTo(target.mento) < 0) {
                return -1;
            } else {
                return Integer.compare(0, this.menti.compareTo(target.menti));
            }
        }
    }
}
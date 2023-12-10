import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        /**
         * i == 1 -> 한번씩 섭스트링을 0 1 / 1 2 / 2 3 이렇게 돌면서 확인
         * i == 2 -> 0 2 / 1 3 /
         * */
        Set<String> answer = new HashSet<>();
        for (int i = 1; i <= word.length(); i++) {
            for (int j = i; j <= word.length(); j++) {
                answer.add(word.substring(j - i, j));
            }
        }
        System.out.println(answer.size());
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static List<Character> DNAs = List.of('A', 'C', 'G', 'T');
    static Map<Character, Integer> require = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int wordLength = Integer.parseInt(tokenizer.nextToken());
        int passwordLength = Integer.parseInt(tokenizer.nextToken());
        String words = bufferedReader.readLine();

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (Character dna : DNAs) {
            require.put(dna, Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i = 0; i < passwordLength; i++) {
            char target = words.charAt(i);
            require.put(target, require.get(target) - 1);
        }
        if (checkRequire()) count += 1;

        for (int i = passwordLength; i < wordLength; i++) {
            char prev = words.charAt(i - passwordLength);
            char post = words.charAt(i);

            require.put(prev, require.get(prev) + 1);
            require.put(post, require.get(post) - 1);

            if (checkRequire()) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    static boolean checkRequire() {
        for (Character key : require.keySet()) {
            if (require.get(key) > 0) {
                return false;
            }
        }
        return true;
    }
}
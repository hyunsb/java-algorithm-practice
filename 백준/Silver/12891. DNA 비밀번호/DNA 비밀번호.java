import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static List<String> DNAs = List.of("A", "C", "G", "T");
    static Map<String, Integer> require = new HashMap<>();
    static Map<String, Integer> temp = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int wordLength = Integer.parseInt(tokenizer.nextToken());
        int passwordLength = Integer.parseInt(tokenizer.nextToken());
        String word = bufferedReader.readLine();

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (String dna : DNAs) {
            require.put(dna, Integer.parseInt(tokenizer.nextToken()));
            temp.put(dna, 0);
        }

        String[] words = word.split("");
        for (int i = 0; i < passwordLength; i++) {
            String target = words[i];
            temp.put(target, temp.get(target) + 1);
        }
        if (checkRequire()) count += 1;

        for (int i = passwordLength; i < wordLength; i++) {
            String prev = words[i-passwordLength];
            String next = words[i];

//            System.out.println("prev: " + prev + " next: " + next);
//            System.out.println(temp);

            temp.put(prev, temp.get(prev) - 1);
            temp.put(next, temp.get(next) + 1);

            if (checkRequire()) count += 1;
        }

        System.out.println(count);
    }

    static boolean checkRequire() {
        for (String dna : DNAs) {
            int req = require.get(dna);
            int target = temp.get(dna);
//            System.out.println(dna + "= req : " + req + " target: " + target);

            if (target < req) return false;
        }
        return true;
    }
}
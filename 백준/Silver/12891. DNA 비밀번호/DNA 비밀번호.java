import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());

        String dnaStr = bufferedReader.readLine();

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        Map<String, Integer> dnaMap = Map.of(
                "A", Integer.parseInt(tokenizer.nextToken()),
                "C", Integer.parseInt(tokenizer.nextToken()),
                "G", Integer.parseInt(tokenizer.nextToken()),
                "T", Integer.parseInt(tokenizer.nextToken())
        );

        int count = 0;
        int start = 0, end = s;
        String[] dna = dnaStr.split("");

        Map<String, Integer> checker = new HashMap<>();
        for (int i = 0; i < end; i++) {
            String target = dna[i];
            checker.put(target, checker.getOrDefault(target, 0) + 1);
        }
        if (check(checker, dnaMap)) count += 1;

        for (; end < dna.length; end++) {
            checker.put(dna[start], checker.get(dna[start]) - 1);
            checker.put(dna[end], checker.getOrDefault(dna[end], 0) + 1);
            start += 1;

            boolean flag = check(checker, dnaMap);
            if (flag) count += 1;
        }

        System.out.println(count);
    }

    private static boolean check(Map<String, Integer> checker, Map<String, Integer> dnaMap) {
        boolean flag = true;

        for (String key : dnaMap.keySet()) {
            if (dnaMap.get(key) > checker.getOrDefault(key, 0)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
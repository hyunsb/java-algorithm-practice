import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        Set<Integer> truth = new HashSet<>(n);
        boolean[] isVisit = new boolean[m];
        Map<Integer, List<Integer>> party = new HashMap<>(m);

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int loof = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < loof; i++) {
            truth.add(Integer.parseInt(tokenizer.nextToken()));
        }
//        System.out.println(truth);

        for (int i = 0; i < m; i++) {
            party.put(i, new ArrayList<>());
            String[] arr = bufferedReader.readLine().split(" ");
            int count = Integer.parseInt(arr[0]);
            for (int j = 1; j <= count; j++) {
                party.get(i).add(Integer.parseInt(arr[j]));
            }
        }
//        System.out.println(party);

        // set의 사이즈가 변함이 없을 때까지 루프를 돈다.
        int preSetSize = -1;
        while (preSetSize != truth.size()) {
            preSetSize = truth.size();

            for (Integer key : party.keySet()) {
                List<Integer> list = party.get(key);

                boolean isContains = false;
                for (Integer integer : truth) {
                    if (list.contains(integer)) {
                        isContains = true;
                        break;
                    }
                }

                if (!isVisit[key] && isContains) {
                    isVisit[key] = true;
                    truth.addAll(list);
                }
            }
//            System.out.println(truth);
//            System.out.println();
        }

        int count = 0;
        for (boolean b : isVisit) {
            if (!b) count += 1;
        }
        System.out.println(count);
    }
}
package 소프티어.safebraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int bag = Integer.parseInt(st.nextToken());
        int kindOfGem = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> gems = new HashMap<>();

        while(kindOfGem-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            gems.put(price, gems.getOrDefault(price, 0) + weight);
        }

        List<Integer> keys = new ArrayList(gems.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        int result = 0;
        for (int price : keys) {
            int weight = gems.get(price);

            if (weight <= bag) {
                result += (weight * price);
                bag -= weight;
            } else {
                result += (bag * price);
                break;
            }
        }
        System.out.println(result);
    }
}

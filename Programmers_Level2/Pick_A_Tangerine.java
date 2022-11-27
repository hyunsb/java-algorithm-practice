package Programmers_Level2;

import java.util.*;

public class Pick_A_Tangerine {
    public static void main(String[] args) {
        Pick_A_Tangerine T = new Pick_A_Tangerine();
        Scanner sc = new Scanner(System.in);

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(T.solution(k, tangerine));
    }

    public int solution(int k, int[] tangerine){
        int answer = 0;
        int sum = 0;

        HashMap<Integer, Integer> tangerineMap = new HashMap<>();

        for(int i : tangerine)
            tangerineMap.put(i, tangerineMap.getOrDefault(i, 0) + 1);

        List<Integer> tangerineCount = new ArrayList<>(tangerineMap.values());
        tangerineCount.sort(Comparator.reverseOrder());

        for(int i : tangerineCount){
            if(sum >= k) break;
            sum += i;
            answer += 1;
        }

        return answer;
    }
}

import java.util.*;
class Solution {
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
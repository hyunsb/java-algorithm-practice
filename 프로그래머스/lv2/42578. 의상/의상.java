import java.util.HashMap;
class Solution {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }
        
        return answer - 1;
    }
}
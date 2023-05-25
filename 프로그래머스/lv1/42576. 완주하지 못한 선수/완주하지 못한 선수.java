import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : completion) {
            map.put(str, map.get(str) - 1);
        }

        for (String s : map.keySet()) {
            if (map.get(s) != 0) answer = s;
        }

        return answer;
    }
}
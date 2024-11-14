import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            char change = target;
            
            if (target != ' ') {
                change = (char) (target + n);
                
                if ('A' <= target && target <= 'Z') {
                    if (change > 90) {
                        change = (char) (change - 'Z' + 64);
                    }
                } else if ('a' <= target && target <= 'z') {
                    if (change > 122) {
                        change = (char) (change - 'z' + 96);
                    }
                }
            }
            answer.append(change);
        }
        
        return answer.toString();
    }
}
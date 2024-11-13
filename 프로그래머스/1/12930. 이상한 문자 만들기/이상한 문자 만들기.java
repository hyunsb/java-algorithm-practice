import java.util.*;

class Solution {
    
    private static final char BLANK = ' ';
    
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int wordIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            
            char target = Character.toLowerCase(s.charAt(i));
            
            if (target == BLANK) {
                answer.append(BLANK);
                wordIndex = 0;
                continue;
            }
            
            if (wordIndex % 2 == 0) {
                target = Character.toUpperCase(target);
            }
            answer.append(target);
            wordIndex += 1;
        }
        
        return answer.toString();
    }
}
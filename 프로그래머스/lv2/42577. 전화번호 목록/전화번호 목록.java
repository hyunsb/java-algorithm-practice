import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> p = new HashSet<>(Arrays.asList(phone_book));

        for (int i = 0; i < p.size(); i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (p.contains(phone_book[i].substring(0, j)))
                    return false;
            }
        }
        return true;
    }
}
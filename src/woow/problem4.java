package woow;

import java.util.HashMap;
import java.util.Map;

public class problem4 {
    public static void main(String[] args) {

        String word = "I love you";
        String answer = "";

        char[] code = {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P',
                'O', 'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};

        for(int i=0; i < word.length(); i++){
            char tmp = word.charAt(i);
            if( (65 <= tmp) && (tmp <= 90)){
                answer += code[tmp-65];
            } else if ((97 <= tmp) && (tmp <= 122)) {
                answer += Character.toString(code[tmp-97]).toLowerCase();
            } else {
                answer += tmp;
            }
        }

        System.out.println(answer);
    }

    public static String sol1(String str){
        Map<Character, Character> map = new HashMap<Character, Character>();
        return "";
    }

}

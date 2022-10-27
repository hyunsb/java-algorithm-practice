package woow;

import java.util.ArrayList;

public class problem2 {
    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";

        ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0; i < cryptogram.length(); i++){
            if(i == cryptogram.length()-1) list.add(cryptogram.charAt(i));
            else{
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) i++;
                else list.add(cryptogram.charAt(i));
            }
        }

    }

    public static String solution(String cryptogram){
        String answer = "";

        return answer;
    }
}

package woow;

import java.util.ArrayList;

public class problem2 {
    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";

//        System.out.println(solution(cryptogram));
        System.out.println(solution2(cryptogram));
    }

    public static String solution2(String cryptogram){
        while(true) {
            String temp = "";
            for (int i = 0; i < cryptogram.length(); i++) {
                if (i == cryptogram.length() - 1) temp += cryptogram.charAt(i);
                else {
                    if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) i++;
                    else temp += cryptogram.charAt(i);
                }
            }
            System.out.println(cryptogram + "|" + temp);
            if (cryptogram.equals(temp)) return temp;
            else cryptogram = temp;
        }
    }

    public static String solution(String cryptogram){
        String answer = "";

        ArrayList<Character> list = new ArrayList<Character>();

        for (int i=0; i < cryptogram.length(); i++){
            if(i == cryptogram.length()-1) {
                list.add(cryptogram.charAt(i));
            }
            else{
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) i++;
                else list.add(cryptogram.charAt(i));
            }
        }

        return answer;
    }
}

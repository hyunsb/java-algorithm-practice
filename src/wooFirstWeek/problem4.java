package wooFirstWeek;

public class problem4 {
    public static void main(String[] args) {

        String word = "I love you";
        System.out.println(sol1(word));

    }

    public static String sol1(String word){
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

        return answer;
    }
}

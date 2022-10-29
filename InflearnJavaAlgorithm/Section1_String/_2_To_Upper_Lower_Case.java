import java.util.Scanner;

public class _2_To_Upper_Lower_Case {

    public String solution(String str){
        String answer = "";
        for (char c : str.toCharArray()){
            answer += upperToLow(c);
        }
        return answer;
    }

    public char upperToLow(char c){
        if( 91 > c && c >= 65) return Character.toLowerCase(c);
        if( 123 > c && c >= 97) return Character.toUpperCase(c);
        return c;
    }

    public static void main(String[] args) {
        _2_To_Upper_Lower_Case T = new _2_To_Upper_Lower_Case();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}

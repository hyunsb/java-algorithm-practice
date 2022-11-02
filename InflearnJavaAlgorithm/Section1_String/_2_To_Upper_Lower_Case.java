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

    public String solution2(String str){
        String answer = "";
        for (char x : str.toCharArray()){
            answer +=  upperToLow2(x);
        }
        return answer;
    }

    public char upperToLow2(char x){
        if(Character.isLowerCase(x)) return Character.toUpperCase(x);
        if(Character.isUpperCase(x)) return Character.toLowerCase(x);
        return x;
    }

    public static void main(String[] args) {
        _2_To_Upper_Lower_Case T = new _2_To_Upper_Lower_Case();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
        System.out.println(T.solution2(str));
    }
}

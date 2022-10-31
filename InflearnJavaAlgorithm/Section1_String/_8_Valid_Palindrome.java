import java.util.Scanner;

public class _8_Valid_Palindrome {
    public String solution(String string){
        String stringReverse = new StringBuilder(string).reverse().toString();
        return extractionAlphabet(string).equalsIgnoreCase(extractionAlphabet(stringReverse)) ? "YES" : "NO";
    }

    public String extractionAlphabet(String word){
        String answer = "";
        for (char x : word.toCharArray()) {
            if(Character.isAlphabetic(x)) answer += x;
        }
        return answer;
    }


    public static void main(String[] args) {
        _8_Valid_Palindrome T = new _8_Valid_Palindrome();
        Scanner sc = new Scanner(System.in);
        String string = "kdjg$@kjkldjkg%@dkjgkj";
//        String string = sc.next();
        System.out.println(T.solution(string));
    }
}

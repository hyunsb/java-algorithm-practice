import java.util.Scanner;

public class _8_Valid_Palindrome {
    public String solution(String string){
        String stringReverse = new StringBuilder(string).reverse().toString();
        return extractionAlphabet(string).equalsIgnoreCase(extractionAlphabet(stringReverse)) ? "YES" : "NO";
    }

    public String extractionAlphabet(String word){
        StringBuilder answer = new StringBuilder();
        for (char x : word.toCharArray()) {
            if(Character.isAlphabetic(x)) answer.append(x);
        }
        return answer.toString();
    }

    public String solution2(String string){
        string = string.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(string).reverse().toString();
        return string.equals(tmp) ? "YES" : "NO";
    }


    public static void main(String[] args) {
        _8_Valid_Palindrome T = new _8_Valid_Palindrome();
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(T.solution(string));
        System.out.println(T.solution2(string));
    }
}

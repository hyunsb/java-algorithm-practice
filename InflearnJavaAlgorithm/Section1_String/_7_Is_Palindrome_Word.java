import java.util.*;
public class _7_Is_Palindrome_Word {
    public String solution(String word){
        String lWord = "", rWord="";
        int lt = 0, rt = word.length()-1;
        char[] charList = word.toCharArray();

        while (lt < rt) {
            lWord += charList[lt];
            rWord += charList[rt];
            lt++;
            rt--;
        }

        return lWord.equalsIgnoreCase(rWord) ? "YES" : "NO";
    }
    public static void main(String[] args) {
        _7_Is_Palindrome_Word T = new _7_Is_Palindrome_Word();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(T.solution(word));
    }
}

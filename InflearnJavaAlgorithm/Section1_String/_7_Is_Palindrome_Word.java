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

    public String solution2(String word){
        String answer = "YES";
        int len = word.length();
        for(int i = 0; i < len/2; i++){
            if(word.charAt(i)!=word.charAt(len-1-i)) {
                answer = "NO";
                return answer;
            }
        }
        return answer;
    }

    public String solution3(String word){
        String answer = "YES";
        String tmp = new StringBuilder(word).reverse().toString();
        if(!word.equalsIgnoreCase(tmp)) answer = "NO";
        return answer;
    }

    public static void main(String[] args) {
        _7_Is_Palindrome_Word T = new _7_Is_Palindrome_Word();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(T.solution(word));
        System.out.println(T.solution2(word));
        System.out.println(T.solution3(word));
    }
}
import java.util.Scanner;

public class _5_Reverse_Specific_Word {

    // 클린코드의 원칙에 따라 리팩토링 해보기
    public String solution(String word){
        String answer = "";

        char[] charList = word.toCharArray();
        int lt = 0, rt = charList.length-1;
        while (lt < rt){
            if (!Character.isAlphabetic(charList[lt])) lt++;
            else if (!Character.isAlphabetic(charList[rt])) rt--;
            else {
                char tmp = charList[lt];
                charList[lt] = charList[rt];
                charList[rt] = tmp;
                lt ++;
                rt --;
            }
        }
        answer = String.valueOf(charList); // Static method 이다
        return answer;
    }

    public static void main(String[] args) {
        _5_Reverse_Specific_Word T = new _5_Reverse_Specific_Word();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(T.solution(word));
    }
}

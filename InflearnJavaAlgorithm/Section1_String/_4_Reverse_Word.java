import java.util.ArrayList;
import java.util.Scanner;

public class _4_Reverse_Word {
    public ArrayList<String> solution(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<String>();

        for(int i=0; i < n; i++) {
            StringBuilder sb = new StringBuilder(strings[i]);
            answer.add(sb.reverse().toString());
        }

        return answer;
    }

    public ArrayList<String> solution2(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<String>();

        for(String str : strings){
            //StringBuilder는 객체를 여러개 만들지 않음 - 공부할 것
            String tmp = new StringBuilder(str).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public ArrayList<String> solution3(int n, String[] strings) {
        ArrayList<String> answer = new ArrayList<String>();
        for(String str : strings){
            char[] chars = str.toCharArray();
            int lt = 0, rt = chars.length-1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }

            String reverseWord = String.valueOf(chars);
            answer.add(reverseWord);
        }
        return answer;
    }

    public static void main(String[] args) {
        _4_Reverse_Word T = new _4_Reverse_Word();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];

        for(int i=0; i < n; i++){
            strings[i] = sc.next();
        }

        for(String str : T.solution(n, strings)){
            System.out.println(str);
        }
    }
}

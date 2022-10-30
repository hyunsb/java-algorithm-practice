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

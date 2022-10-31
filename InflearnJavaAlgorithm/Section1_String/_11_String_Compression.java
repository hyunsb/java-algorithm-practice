import java.io.Serializable;
import java.util.Scanner;

public class _11_String_Compression {
    public String solution(String str){
        StringBuilder answer = new StringBuilder();

        int cnt = 1;
        for(int i = 0; i < str.length(); i++){
            if (i == str.length()-1 || str.charAt(i) != str.charAt(i+1)) {
                answer.append(str.charAt(i));
                if(cnt==1) continue;
                answer.append(cnt);
                cnt = 1;
                continue;
            }
            if (str.charAt(i) == str.charAt(i+1)) cnt++;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        _11_String_Compression T = new _11_String_Compression();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}

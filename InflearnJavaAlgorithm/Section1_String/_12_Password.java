import java.util.Scanner;

public class _12_Password {
    public String solution(int count, String password){
        StringBuilder answer = new StringBuilder();

        int len = password.length()/count;

        for(int i =0; i < count; i++){
            String word = password.substring(0, len)
                    .replace('#', '1')
                    .replace('*', '0');
            int num = Integer.parseInt(word, 2); // String word를 2진수로 인식하여 Int로 변환
            answer.append((char)num);
            password = password.substring(len);
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        _12_Password T = new _12_Password();

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        String password = sc.next();

        System.out.println(T.solution(count, password));
    }
}

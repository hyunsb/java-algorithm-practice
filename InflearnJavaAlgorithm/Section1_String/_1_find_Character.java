import java.util.Scanner;

public class _1_find_Character {
    public int solution(String str, char c){
        int answer = 0;

        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for(int i=0; i<str.length(); i++) answer += (str.charAt(i) == c) ? 1 : 0;

        return answer;
    }

    public static void main(String[] args) {
        _1_find_Character T = new _1_find_Character();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(T.solution(str, c));

    }
}

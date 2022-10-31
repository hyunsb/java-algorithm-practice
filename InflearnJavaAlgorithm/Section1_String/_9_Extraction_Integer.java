import java.util.Scanner;

public class _9_Extraction_Integer {
    public int solution(String string){
        return Integer.parseInt(string.replaceAll("[^0-9]", ""));
    }

    public int solution2(String string){
        int answer = 0;
        for (char x : string.toCharArray()){
            if( 48 <= x && x <= 57) answer = answer * 10 + (x - 48);
        }
        return answer;
    }

    public static void main(String[] args) {
        _9_Extraction_Integer T = new _9_Extraction_Integer();
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        System.out.println(T.solution(string));
        System.out.println(T.solution2(string));
    }
}

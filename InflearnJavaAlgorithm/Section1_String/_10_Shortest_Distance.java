import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10_Shortest_Distance {

    public List<Integer> solution(String str, char c){
        List<Integer> answer = new ArrayList<>();

        int count = 0;
        char[] charList = str.toCharArray();
//        for (char x : str.toCharArray()) answer.add( (x==c) ? count = 0 : ++count );
        for (int i = 0; i < charList.length; i++){
            if ( c == charList[i]) {
                answer.add(0);
                count = 0;
                continue;
            }
            answer.add(++count);
        }
        count = 0;
        for (int i = charList.length-1; i > 0; i--) {
            if ( c == charList[i] ) {
                count = 0;
                continue;
            }
            if ( ++count < answer.get(i)) answer.set(i, count);
        }
        return answer;
    }

    public List<Integer> solution2(String str, char c){
        List<Integer> answer = new ArrayList<Integer>();

        int dist = str.length();
        for (char x : str.toCharArray()) answer.add( (x==c) ? dist = 0 : ++dist );

        dist = str.length();
        for (int i = str.length()-1; i >= 0; i--)
            answer.set(i, str.charAt(i) == c ? dist = 0 : Math.min(answer.get(i), ++dist));

        return answer;
    }

    // 인프런 강의 알고리즘
    public int[] solution3(String str, char c){
        int[] answer = new int[str.length()];
        int p = str.length();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
        }
        p = str.length();
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == c) p = 0;
            else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _10_Shortest_Distance T = new _10_Shortest_Distance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        for(int i : T.solution(str, c)) System.out.print(i + " ");
        System.out.println();
        for(int i : T.solution2(str, c)) System.out.print(i + " ");
        System.out.println();
        for(int i : T.solution3(str, c)) System.out.print(i + " ");
    }
}

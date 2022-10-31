import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        _10_Shortest_Distance T = new _10_Shortest_Distance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int i : T.solution(str, c)) System.out.print(i);
    }
}

import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _10_Shortest_Distance {

    public List<Integer> solution(String str, char c){
        List<Integer> answer = new ArrayList<>();
        int count = 0;

        for (char x : str.toCharArray()) answer.add( (x==c) ? count = 0 : ++count );

        return answer;
    }

    public List<Integer> solution2(String str, char c){

    }

    public static void main(String[] args) {
        _10_Shortest_Distance T = new _10_Shortest_Distance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(T.solution(str, c));
        System.out.println(T.solution2(str, c));
    }
}

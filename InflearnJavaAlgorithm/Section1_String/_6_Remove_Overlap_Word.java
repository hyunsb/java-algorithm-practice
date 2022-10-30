import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _6_Remove_Overlap_Word {
    public String solution(String word){
        Set<String> set = new LinkedHashSet<>();
        for(String str : word.split("")) set.add(str);
        return String.join("", set);
    }

    public String solution2(String word){
        String answer = "";
        for(int i = 0; i < word.length(); i++){
            if(word.indexOf(word.charAt(i)) == i) answer += word.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        _6_Remove_Overlap_Word T = new _6_Remove_Overlap_Word();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(T.solution(word));
        System.out.println(T.solution2(word));
    }
}

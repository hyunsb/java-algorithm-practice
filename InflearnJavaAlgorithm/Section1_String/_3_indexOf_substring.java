import java.util.Scanner;

public class _3_indexOf_substring {
    public String solution(String str){
        String answer = "";

        for (String word : str.split(" ")){
            answer = compareLength(word, answer);
        }
        return answer;
    }

    public String compareLength(String word, String answer){
        return (word.length() > answer.length()) ? word : answer;
    }

    public static void main(String[] args) {
        _3_indexOf_substring T = new _3_indexOf_substring();
        Scanner sc = new Scanner(System.in);
        // 한줄 입력
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}

import java.util.Scanner;

public class _3_indexOf_substring {
    public String solution(String str){
        String answer = "";

        for (String word : str.split(" ")){
            answer = compareLength(word, answer);
            //answer = word.length() > answer.length() ? word : answer;
        }
        return answer;
    }

    public String compareLength(String word, String answer){
        return (word.length() > answer.length()) ? word : answer;
    }

    public String solution2(String str){
        String answer = "";

        int max = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            int len = x.length();
            if(len > max) {
                max = len;
                answer = x;
            }
        }
        return answer;
    }

    public String solution3(String str){
        String answer = "";
        int max = Integer.MIN_VALUE, position;
        while ((position = str.indexOf(" ")) != -1){
            String tmp = str.substring(0, position);
            int len = tmp.length();
            if(len > max){
                max = len;
                answer = tmp;
            }
            str = str.substring(position+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        _3_indexOf_substring T = new _3_indexOf_substring();
        Scanner sc = new Scanner(System.in);
        // 한줄 입력
        String str = sc.nextLine();
        System.out.println(T.solution(str));
        System.out.println(T.solution3(str));
    }
}

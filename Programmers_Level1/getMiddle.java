package Level1;

public class getMiddle {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        int strLen = s.length();

        answer = (strLen%2==0)?strArr[strLen/2-1]+strArr[strLen/2]:strArr[strLen/2];

        return answer;
    }
}

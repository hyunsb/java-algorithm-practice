package Level1;

public class getMiddleExercise {
    public String solution(String s) {
        /*
        substring(startIndex, endIndex)
        startIndex 부터 endIndex(포함X) 까지
        **/
        return s.substring((s.length()-1)/2, s.length()/2+1);
    }
}

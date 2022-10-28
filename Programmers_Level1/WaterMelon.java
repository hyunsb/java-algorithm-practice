package Level1;

public class WaterMelon {
    public String solution(int n) {
        String answer = "";
        for(int i=1; i<n+1; i++){
            answer += (i%2==0)?"박":"수";
        }
        return answer;
    }
}

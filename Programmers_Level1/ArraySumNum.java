package Level1;

public class ArraySumNum {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int i : numbers) answer -= i;
        return answer;
    }
}

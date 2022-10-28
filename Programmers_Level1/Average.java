package Level1;
public class Average {
    public double solution(int[] arr) {
        double answer = 0;

        if (arr != null) {
            for (int i : arr) {
                answer += i;
            }
        }

        return answer/arr.length;
    }
}

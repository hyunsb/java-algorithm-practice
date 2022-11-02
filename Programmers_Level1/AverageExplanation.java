package Level1;

import java.util.Arrays;

public class AverageExplanation {
    public double solution(int[] arr) {
        return (int) Arrays.stream(arr).average().orElse(0);
    }
}

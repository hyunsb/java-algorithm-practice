import java.util.*;

class Solution {

    int[] memo;

    public int solution(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1로 초기화 (계산 안 된 값 표시)
        return fibonacci(n);
    }

    private int fibonacci(int n) {
        int MOD = 1234567;

        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != -1) return memo[n];

        memo[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % MOD;
        return memo[n];
    }
}

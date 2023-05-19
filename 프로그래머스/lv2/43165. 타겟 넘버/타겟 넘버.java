class Solution {
    static int answer = 0;
    
    static int solution(int[] numbers, int target){
        dfs(0, target, 0, numbers);
        return answer;
    }

    static void dfs(int depth, int target, int sum, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        dfs(depth+1, target, sum+numbers[depth], numbers);
        dfs(depth+1, target, sum-numbers[depth], numbers);
    }
}
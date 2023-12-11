import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> pick = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int item = board[i][move - 1];
                if (item != 0) {
                    if (!pick.isEmpty() && pick.peek() == item) {
                        pick.pop();
                        answer += 2;
                    } else {
                        pick.push(item);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
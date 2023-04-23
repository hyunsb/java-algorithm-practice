import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
        public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        Queue<Integer> main = new LinkedList<>();
        int defaultBox = 1;
        int wantBoxIdx = 0;

        while (true){
            if(!sub.isEmpty() && sub.peek() == order[wantBoxIdx]){
                main.offer(sub.pop());
                wantBoxIdx++;
                continue;
            }
            if(defaultBox > order.length) break;

            if(defaultBox == order[wantBoxIdx]){
                main.offer(defaultBox++);
                wantBoxIdx++;
            }else sub.push(defaultBox++);
        }

        return main.size();
    }
}
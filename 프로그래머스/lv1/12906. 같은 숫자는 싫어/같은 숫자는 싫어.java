import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i : arr){
            if (stack.isEmpty() || (stack.peek() != i)) stack.add(i);
        }
        
        int[] answer = new int[stack.size()];
        
        int count = 0;
        for(int i : stack){
            answer[count++] = i;
        }

        return answer;
    }
}
package Level1;

import java.util.Stack;

public class RemoveBothNumber {
    public static void main(String[] args) {
        // Programmers 코딩테스트 - 스택/큐 - 같은 숫자는 싫어
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(solution(arr));
    }

    // Use Stack
    public static int[] solution(int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length-1; i++){
            if (i == 0) stack.add(arr[i]);
            else {
                if (stack.peek() != arr[i]) stack.add(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i=stack.size()-1; i >= 0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}

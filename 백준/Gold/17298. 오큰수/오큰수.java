import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        
        int[] answer = new int[n];
        int[] nums = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
        }
        
        Stack<Integer> numsIndex = new Stack<>();
        numsIndex.push(0);
        for (int i = 0; i < n; i++) {
            int target = nums[i];
            
            while (!numsIndex.isEmpty() && nums[numsIndex.peek()] < target) {
                answer[numsIndex.pop()] = target;
            }
            numsIndex.push(i);
        }
        
        while (!numsIndex.isEmpty()) {
            answer[numsIndex.pop()] = -1;
        }
        
        StringBuilder answers = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answers.append(answer[i]).append(" ");
        }
        System.out.println(answers);
    }
}
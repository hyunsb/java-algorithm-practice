import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(int n : priorities) queue.offer(n);

        while(!queue.isEmpty()){
            for(int i=0; i < priorities.length; i++){
                System.out.print("Queue peek : " + queue.peek());
                System.out.println(" | priorities[i] : " + priorities[i] + " | Queue : " + queue);

                if(queue.peek() == priorities[i]){
                    if( location == i){
                        return answer;
                    }
                    answer++;
                    queue.poll();
                    System.out.println("deQueue, count++, answer = " + answer);
                }
            }
        }
        return answer;
    }
}
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.offer(scoville[i]);
        }
        
        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) return -1;
            priorityQueue.add(priorityQueue.poll() + priorityQueue.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}
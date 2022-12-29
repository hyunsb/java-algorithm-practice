package Level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * */
public class Delivery_Box {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> saveOrder = new Stack<>();

        int defaultOrder = 1;
        int nowOrder = 0;

        while (true) {
            System.out.println(order[nowOrder] + " " + defaultOrder + " : " + saveOrder);
            if(!saveOrder.isEmpty() && saveOrder.peek() == order[nowOrder]){
                answer++;
                saveOrder.pop();
                nowOrder++;
                continue;
            }

            if(defaultOrder > order.length) break;

            if(defaultOrder == order[nowOrder]){
                answer++;
                nowOrder++;
            }else {
                saveOrder.push(defaultOrder);
            }
            defaultOrder++;
        }

        return answer;
    }

    public int solution2(int[] order){
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

    public static void main(String[] args) {
        Delivery_Box main = new Delivery_Box();
        int[] order = {5, 4, 3, 2, 1};
        System.out.println(main.solution2(order));
    }
}

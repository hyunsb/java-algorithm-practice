package Level2;

import java.util.Stack;

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

    public static void main(String[] args) {
        Delivery_Box main = new Delivery_Box();
        int[] order = {4, 3, 1, 2, 5};
        System.out.println(main.solution(order));
    }
}

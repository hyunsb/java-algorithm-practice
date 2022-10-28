package woow;

import java.util.Collections;
import java.util.List;

public class problem5 {
    public static void main(String[] args) {
        System.out.println(sol1(50237));
        System.out.println(sol1(15000));
    }

    public static List<Integer> sol1(int money){
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i = 0; i < moneyList.length; i++){
            answer.add(money/moneyList[i]);
            money %= moneyList[i];
        }
        return answer;
    }
}

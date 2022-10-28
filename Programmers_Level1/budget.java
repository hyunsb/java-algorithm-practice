package Level1;

import java.util.Arrays;

public class budget {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int sumCost = 0;
        int count = 0;

        Arrays.sort(d);
        for(int cost : d){
            if( sumCost + cost <= budget ) {
                sumCost += cost;
                count++;
            }
            else { return count; }
        }

        return count;
    }

    public static int solution2(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for(int cost : d){
            budget -= cost;
            if(budget < 0) break;
            answer++;
        }

        return answer;
    }

}

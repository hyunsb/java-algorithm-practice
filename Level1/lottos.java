package Level1;

import java.util.Arrays;

public class lottos {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        for(int n : solution(lottos, win_nums)){
            System.out.println(n);
        }
    }

    public static int[] solution(int[] lottos, int[] win_nums){
        int[] answer = new int[2];
        int ZeroCount = 0;
        int rankCount = 0;

        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) {
                ZeroCount++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]) rankCount++;
            }
        }

        answer[1] = (rankCount <= 1) ? 6 : 7-rankCount;
        answer[0] = (ZeroCount == 6) ? 1 : answer[1]-ZeroCount;

        return answer;
    }
}

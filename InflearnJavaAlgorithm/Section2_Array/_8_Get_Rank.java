package InflearnJavaAlgorithm.Section2_Array;

import java.util.*;

public class _8_Get_Rank {
    public List<Integer> solution(int length, List<Integer> score){
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<length; i++){
            int rank = 1;
            for(int j=0; j<length; j++){
                if(score.get(i) < score.get(j)) rank ++;
            }
            answer.add(rank);
        }

        return answer;
    }

    public static void main(String[] args) {
        _8_Get_Rank T = new _8_Get_Rank();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        List<Integer> scores = new ArrayList<>();
        for(int i=0; i<length; i++) scores.add(sc.nextInt());

        for(int i : T.solution(length, scores)) System.out.print(i + " ");
    }
}

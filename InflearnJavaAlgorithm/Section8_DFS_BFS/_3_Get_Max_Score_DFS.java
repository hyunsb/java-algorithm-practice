package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.*;
public class _3_Get_Max_Score_DFS{
    static int answer = Integer.MIN_VALUE;
    static int questionNumber, deadline;

    public void DFS(int level, int score, int time, int[] questionScore, int[] questionTime){
        if(time > deadline)
            return;

        if( level == questionNumber) {
            answer = Math.max(answer, score);
            return;
        }else {
            DFS(level+1, score+questionScore[level], time+questionTime[level], questionScore, questionTime);
            DFS(level+1, score, time, questionScore, questionTime);
        }
    }

    public static void main(String[] args){
        _3_Get_Max_Score_DFS T = new _3_Get_Max_Score_DFS();
        Scanner sc = new Scanner(System.in);

        questionNumber = sc.nextInt();
        deadline = sc.nextInt();

        int[] questionScore = new int[questionNumber];
        int[] questionTime = new int[questionNumber];

        for(int i=0; i<questionNumber; i++){
            questionScore[i]=sc.nextInt();
            questionTime[i]=sc.nextInt();
        }

        T.DFS(0, 0, 0, questionScore, questionTime);
        System.out.println(answer);
    }
}

class _3_Get_Max_Score_DFS_Inflearn {

}
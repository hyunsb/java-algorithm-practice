package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.*;
class _3_Get_Max_Score_DFS
{
    static int answer = Integer.MIN_VALUE;
    static int question, deadline;

    public void DFS(int level, int score, int time, int[] a, int[] b){
        if( (time + b[level]) > deadline || level == question) {
            answer = Math.max(answer, score);
        }else {
            DFS(level+1, score+a[level], time+b[level], a, b);
            DFS(level+1, score, time, a, b);
        }
    }

    public static void main(String[] args){
        _3_Get_Max_Score_DFS T = new _3_Get_Max_Score_DFS();
        Scanner sc = new Scanner(System.in);

        question = sc.nextInt();
        deadline = sc.nextInt();

        int[] a=new int[question];
        int[] b=new int[question];

        for(int i=0; i<question; i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }

        T.DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }
}
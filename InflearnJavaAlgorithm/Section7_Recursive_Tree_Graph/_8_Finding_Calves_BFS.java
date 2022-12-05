package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _8_Finding_Calves_BFS {
    public static void main(String[] args) {
        _8_Finding_Calves_BFS T = new _8_Finding_Calves_BFS();
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();
        System.out.println(T.solution(S, E));
        System.out.println(T.BFS(S, E));
    }

    int answer = 0;
    int[] dist = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int S, int E){
        ch = new int[10001];
        ch[S] = 1;
        Q.offer(S);
        int L = 0;

        while (!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                int x = Q.poll();
                for(int distance : dist) {
                    int nx = x + distance;
                    if(nx == E) return L+1;
                    if(1 <= nx && nx <= 10000 && ch[nx] == 0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return L;
    }

    public int solution(int S, int E){
        int count = 0;
        int dist = E - S;

        if(dist < 0) return Math.abs(dist);

        while (dist != 0){
            if(dist < 0){
                dist += 1;
                count++;
            }else if(dist-1 < Math.abs(dist-5)){
                dist -= 1;
                count++;
            }else {
                dist -= 5;
                count++;
            }
        }
        return count;
    }
}

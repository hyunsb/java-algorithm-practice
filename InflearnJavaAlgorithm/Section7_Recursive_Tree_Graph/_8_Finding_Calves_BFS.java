package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _8_Finding_Calves_BFS {
    public static void main(String[] args) {
        _8_Finding_Calves_BFS T = new _8_Finding_Calves_BFS();
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();
        System.out.println(T.solution(S, E));
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

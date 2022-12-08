package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _12_Route_Search_DFS_Infearn {
    /**
     * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 수를 출력하는 프로그램을 작성하시오
     * </br>
     * 첫째 줄에는 정점의 수 N과 간선의 수 M이 주어진다.
     * 그 다음줄 부터 연결정보가 주어진다.
     * </br>
     * 노드 경로 이동 시 이미 한 번 방문한 노드는 다시 방문하지 않는다. (ch 배열에 방문 정보 저장)
     * 최대 노드 정점의 수 N번 만큼 재귀 호출하며 이동한다.
     * */

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public void DFS(int v){
        if(v==n) answer++;
        else {
            for(int i=1; i<=n; i++){
                if (graph[v][i] == 1 && ch[i] == 0){
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        _12_Route_Search_DFS_Infearn T = new _12_Route_Search_DFS_Infearn();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[n+1];

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

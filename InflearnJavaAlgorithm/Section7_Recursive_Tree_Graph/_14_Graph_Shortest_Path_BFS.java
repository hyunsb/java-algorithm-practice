package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 그래프의 1범 정점에서 각 정점으로 가는 최소 간선수를 출력하세요.
 * </br>
 * 첫째 줄에는 정점의 수 N과 간선의 수 M이 주어진다.
 * 그 다음 M개의 줄에 걸쳐 연결정보가 주어진다.
 * */
public class _14_Graph_Shortest_Path_BFS {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, dist;

    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        check[v] = 1;
        dist[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()){
            int currentVertex = queue.poll();

            for(int nextVertex : graph.get(currentVertex))
                if(check[nextVertex] == 0){
                    check[nextVertex] = 1;
                    queue.offer(nextVertex);
                    dist[nextVertex] = dist[currentVertex] + 1;
                }
        }
    }

    public static void main(String[] args) {
        _14_Graph_Shortest_Path_BFS T = new _14_Graph_Shortest_Path_BFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());

        check = new int[n+1];
        dist = new int[n+1];

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        T.BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + ": " + dist[i]);
        }
    }
}

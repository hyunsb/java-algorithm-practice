package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class _13_Route_Search_ArrayList {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public void DFS(int v){
        if(v==n) answer++;
        else {
            for(int nv : graph.get(v)){
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        _13_Route_Search_ArrayList T = new _13_Route_Search_ArrayList();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        ch = new int[n+1];
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

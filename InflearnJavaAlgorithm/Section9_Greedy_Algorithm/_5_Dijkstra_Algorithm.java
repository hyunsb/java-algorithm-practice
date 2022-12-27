package Section9_Greedy_Algorithm;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vertex; // 정점
    public int cost; // 간선의 가중치 값

    Edge(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class _5_Dijkstra_Algorithm {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] distance;

    public void solution(int vertex){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(vertex, 0));
        distance[vertex] = 0;

        while (!priorityQueue.isEmpty()){
            Edge temp = priorityQueue.poll();
            int nowVertex = temp.vertex;
            int nowCost = temp.cost;

            if(nowCost > distance[nowVertex]) continue;
            for(Edge ob : graph.get(nowVertex)){
                if(nowCost + ob.cost < distance[ob.vertex]) {
                    distance[ob.vertex] = nowCost + ob.cost;
                    priorityQueue.offer(new Edge(ob.vertex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        _5_Dijkstra_Algorithm main = new _5_Dijkstra_Algorithm();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Edge>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Edge>());

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        main.solution(1);

        for(int i=2; i<=n; i++){
            if(distance[i] != Integer.MAX_VALUE) System.out.println(i + " : " + distance[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
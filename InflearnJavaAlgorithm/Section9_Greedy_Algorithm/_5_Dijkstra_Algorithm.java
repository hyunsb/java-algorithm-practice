package Section9_Greedy_Algorithm;

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


//======================Practice Code===========================//

/**
 * @step1 그래프에 대한 정보를 간선 가중치 기준 오름차순으로 정렬
 * 가능하게끔 정점에 대한 정보를 담은 클래스 생성
 * */
class EdgePrac implements Comparable<EdgePrac>{
    // 정점, 간선 가중치
    public int vertex, cost;

    public EdgePrac(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }

    // 정렬 시(PriorityQueue에 offer 했을 시) 코스트 기준 오름차순 정렬
    @Override
    public int compareTo(EdgePrac o) {
        return this.cost - o.cost;
    }
}


class _5_Dijkstra_Algorithm_Practice{
    static ArrayList<ArrayList<EdgePrac>> graph;
    static int[] distance;

    public void dijkstra(int criteriaVertex){
        PriorityQueue<EdgePrac> edgeList = new PriorityQueue<>();
        // 기준 정점에 대한 정보 저장
        edgeList.offer(new EdgePrac(criteriaVertex, 0));
        distance[criteriaVertex] = 0;

        while (!edgeList.isEmpty()){
            // 현재 정점에 대한 정보 저장
            EdgePrac nowEdge = edgeList.poll();
            int nowVertex = nowEdge.vertex;
            int nowCost = nowEdge.cost;

            // 현재 정점의 가중치가 저장되어 있는 최소 가중치보다 크다면
            // 어떤 정점으로 이동하더라도 최소 가중치가 나올 수 없기 때문에 반복문 스킵
            if(nowCost > distance[nowVertex]) continue;
            // 현재 정점에서 이동할 수 있는 정점에 대한 정보를 차례대로 꺼냄
            for(EdgePrac edge : graph.get(nowVertex)){
                // 현재 정점에서 다른 정점으로 이동했을 때의 가중치가 저장되어 있는 최소 가중치보다 작다면
                if (nowCost + edge.cost < distance[edge.vertex]) {
                    // 해당 정점으로 이동할 수 있는 최소 가중치로 저장
                    distance[edge.vertex] = nowCost + edge.cost;
                    edgeList.offer(new EdgePrac(edge.vertex, distance[edge.vertex]));
                }
            }
        }
    }

    public static void main(String[] args) {
        _5_Dijkstra_Algorithm_Practice main = new _5_Dijkstra_Algorithm_Practice();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 그래프에 대한 정보를 저장하는 리스트 생성
        graph = new ArrayList<ArrayList<EdgePrac>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<EdgePrac>());

        // 그래프 정보 초기화
        for(int i=0; i<m; i++){
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(startVertex).add(new EdgePrac(endVertex, cost));
        }

        // 시작 점으로 부터 각 정점까지의 거리를 저장하는 배열 초기화
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        main.dijkstra(1);

        for(int i=2; i<=n; i++)
            if(distance[i] != Integer.MAX_VALUE)
                System.out.println(i + " : " + distance[i]);
            else System.out.println(i + " : impossible ");
    }
}


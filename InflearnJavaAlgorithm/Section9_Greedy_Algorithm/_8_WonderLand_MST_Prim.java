package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge8 implements Comparable<Edge8>{
    public int endVertex, cost;

    Edge8(int Vertex, int cost){
        this.endVertex = Vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge8 o) {
        return this.cost - o.cost;
    }
}

public class _8_WonderLand_MST_Prim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}

//========================Inflearn Code==========================//

class _8_WonderLand_MST_Prim_Inflearn{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ch = new int[n+1];

        ArrayList<ArrayList<Edge8>> graph = new ArrayList<ArrayList<Edge8>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Edge8>());

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge8(b, c));
            graph.get(b).add(new Edge8(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge8> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge8(1, 0));
        while (!priorityQueue.isEmpty()){
            Edge8 temp = priorityQueue.poll();
            int endVertex = temp.endVertex;
            if(ch[endVertex] == 0){
                ch[endVertex] = 1;
                answer += temp.cost;

                for(Edge8 ob : graph.get(endVertex))
                    if(ch[ob.endVertex] == 0)
                        priorityQueue.offer(new Edge8(ob.endVertex, ob.cost));
            }
        }
        System.out.println(answer);
    }
}

//========================Practice Code==========================//

class _8_WonderLand_MST_Prim_Practice{
    static int[] check;
    public int solution(ArrayList<ArrayList<Edge8>> graph){
        int answer = 0;

        // 현재까지 생성된 트리에서 연결할 수 있는 도로의 코스트를 기준으로 오름차순 정렬된 큐
        PriorityQueue<Edge8> priorityQueue = new PriorityQueue<>();
        // 출발 지점을 임의로 생성하여 큐에 저장한다.
        priorityQueue.offer(new Edge8(1, 0));

        while (!priorityQueue.isEmpty()){
            // 현재 연결할 수 있는 최소의 코스트를 가지는 간선 정보를 저장한다.
            Edge8 currentVertex = priorityQueue.poll();
            // 간선에 연결된 정점을 저장한다.
            int nextVertex = currentVertex.endVertex;

            // 이동할 정점이 아직 연결되지 않은 정점일 시 루틴 실행한다.
            if(check[nextVertex] == 0){
                // 해당 정점을 방문한 정점이라고 저장한다.
                check[nextVertex] = 1;
                // 총 코스트에 해당 정점으로 연결하는 코스트 누적한다.
                answer += currentVertex.cost;

                // 해당 정점을 기준으로 연결되어 있는 간선 정보를 가져온다.
                for(Edge8 edge : graph.get(nextVertex)){
                    // 다음으로 연결 가능한 정점이 아직 방문하지 않은 정점일 경우 우선순위 큐에 저장
                    if(check[edge.endVertex] == 0)
                        priorityQueue.offer(new Edge8(edge.endVertex, edge.cost));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _8_WonderLand_MST_Prim_Practice main = new _8_WonderLand_MST_Prim_Practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 인덱스에 해당하는 정점이 그래프와 연결되어 있는지 확인하는 배열
        check = new int[n+1];

        ArrayList<ArrayList<Edge8>> graph = new ArrayList<ArrayList<Edge8>>();
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Edge8>());
        for(int i=0; i<m; i++){
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(startVertex).add(new Edge8(endVertex, cost));
            graph.get(endVertex).add(new Edge8(startVertex, cost));
        }

        System.out.println(main.solution(graph));
    }
}
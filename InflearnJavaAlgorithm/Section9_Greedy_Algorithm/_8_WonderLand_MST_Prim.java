package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge8 implements Comparable<Edge8>{
    public int Vertex, cost;

    Edge8(int Vertex, int cost){
        this.Vertex = Vertex;
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

        ArrayList<ArrayList<Edge8>> graph = new ArrayList<>();
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
            int endVertex = temp.Vertex;
            if(ch[endVertex] == 0){
                ch[endVertex] = 1;
                answer += temp.cost;

                for(Edge8 ob : graph.get(endVertex))
                    if(ch[ob.Vertex] == 0)
                        priorityQueue.offer(new Edge8(ob.Vertex, ob.cost));
            }
        }
        System.out.println(answer);
    }
}
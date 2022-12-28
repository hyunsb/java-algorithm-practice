package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 최소 스패닝 트리: 그래프에서 가중치 값이 최소가 되는 트리를 추출함
// 그래프 와 트리의 차이: 그래프는 사이클(회로)이 존재, 트리는 사이클 없음
class Edge7 implements Comparable<Edge7>{
    int firstVertex, secondVertex, cost;

    Edge7(int firstVertex, int secondVertex, int cost){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge7 o) {
        return this.cost - o.cost;
    }
}

public class _7_WonderLand_MST_Kruskal {
    static int[] cityGroup;

    public static int Find(int vertex){
        if(vertex == cityGroup[vertex])
            return vertex;
        else return cityGroup[vertex] = Find(cityGroup[vertex]);
    }

    public static void Union(int vertex1, int vertex2){
        int GroupVertex1 = Find(vertex1);
        int GroupVertex2 = Find(vertex2);

        if(GroupVertex1 != GroupVertex2)
            cityGroup[GroupVertex1] = GroupVertex2;
    }

    public static boolean isGroup(int vertex1, int vertex2){
        return Find(vertex1) == Find(vertex2);
    }

    public int solution(ArrayList<Edge7> edgeList){
        int answer = 0;
        Collections.sort(edgeList);

        for(Edge7 edge : edgeList){
            if(!isGroup(edge.firstVertex, edge.secondVertex)){
                answer += edge.cost;
                Union(edge.firstVertex, edge.secondVertex);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _7_WonderLand_MST_Kruskal main = new _7_WonderLand_MST_Kruskal();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        cityGroup = new int[n+1];
        for(int i=1; i<=n; i++)
            cityGroup[i] = i;

        ArrayList<Edge7> edgeList = new ArrayList<>();
        for(int i=0; i<m; i++){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int cost = sc.nextInt();
            edgeList.add(new Edge7(vertex1, vertex2, cost));
        }

        System.out.println(main.solution(edgeList));
    }
}

//=======================Inflearn Code=======================//

class _7_WonderLand_MST_Inflearn{
    static int[] unf;
    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n+1];
        ArrayList<Edge7> arr = new ArrayList<>();

        for(int i=1; i<=n; i++)
            unf[i] = i;

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge7(a, b, c));
        }

        int answer = 0;
        Collections.sort(arr);
        for(Edge7 ob : arr){
            int fv1 = Find(ob.firstVertex);
            int fv2 = Find(ob.secondVertex);
            if(fv1 != fv2){
                answer += ob.cost;
                Union(ob.firstVertex, ob.secondVertex);
            }
        }

        System.out.println(answer);
    }
}
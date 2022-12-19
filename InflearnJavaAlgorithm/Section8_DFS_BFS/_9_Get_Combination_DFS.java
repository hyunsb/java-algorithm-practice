package InflearnJavaAlgorithm.Section8_DFS_BFS;
import java.util.*;

public class _9_Get_Combination_DFS {

}

class _9_Get_Combination_DFS_Inflearn {
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s){
        if(L==m){
            for(int x : combi) System.out.print(x+" ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args){
        _9_Get_Combination_DFS_Inflearn T = new _9_Get_Combination_DFS_Inflearn();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        combi=new int[m];
        T.DFS(0, 1);
    }
}
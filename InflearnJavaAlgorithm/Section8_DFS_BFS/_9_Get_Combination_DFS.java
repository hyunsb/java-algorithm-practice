package Section8_DFS_BFS;
import java.util.*;

/**
 * 조합 구하기
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중   M개를 뽑는 방법의 수를 출력하는 프로그
 * 램을 작성하세요.
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
 * ▣ 출력설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 * */

public class _9_Get_Combination_DFS {
    Scanner sc = new Scanner(System.in);
    int n, m;
    int[] combi;

    _9_Get_Combination_DFS(){
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];

        DFS(0, 1);
    }

    public void DFS(int level, int number){
        if (level == m) {
            for(int x : combi)
                System.out.print(x + " ");
            System.out.println();
        }else {
            for(int i=number; i<=n; i++){
                combi[level] = i;
                DFS(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        _9_Get_Combination_DFS main = new _9_Get_Combination_DFS();
    }
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

class _9_Get_Combination_DFS_Practice{
    static int n, m;
    static int[] combination;

    _9_Get_Combination_DFS_Practice(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combination = new int[m];

        DFS(0, 1);
    }

    public void DFS(int level, int num){
        if(level == m){
            for(int x : combination)
                System.out.print(x + " ");
            System.out.println();
            return;
        }

        for(int i=num; i<=n; i++){
            combination[level] = i;
            DFS(level+1, i+1);
        }
    }

    public static void main(String[] args) {
        _9_Get_Combination_DFS_Practice main = new _9_Get_Combination_DFS_Practice();
    }
}
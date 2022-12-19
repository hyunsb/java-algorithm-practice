package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _8_Sequence_Conjecture_DFS {
    Scanner sc = new Scanner(System.in);
    static int[][] dy;
    static int[] b, p, ch;
    static int n, f;

    static boolean flag = false;

    _8_Sequence_Conjecture_DFS(){
        n = sc.nextInt();
        f = sc.nextInt();

        dy = new int[n][n];
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];

        for(int i=0; i<n; i++)
            b[i] = combi(n-1, i);

        DFS(0, 0);
    }

    public void DFS(int L, int sum){
        if(flag)
            return;

        if(L == n){
            if(sum == f) {
                for(int x : p)
                    System.out.print(x + " ");
                flag = true;
            }
        }else {
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public int combi(int n, int r){
        if(dy[n][r] > 0)
            return dy[n][r];

        if(n==r || r==0)
            return 1;
        else
            return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public static void main(String[] args) {
        _8_Sequence_Conjecture_DFS T = new _8_Sequence_Conjecture_DFS();
    }
}

class _8_Sequence_Conjecture_DFS_Inflearn {
    static int[] b, p, ch;
    static int n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void DFS(int L, int sum){
        if(flag)
            return;

        if(L == n) {
            if(sum == f){
                for(int x : p)
                    System.out.print(x + " ");
                flag = true;
            }
        }else {
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        _8_Sequence_Conjecture_DFS_Inflearn T = new _8_Sequence_Conjecture_DFS_Inflearn();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];

        for(int i=0; i<n; i++)
            b[i] = T.combi(n-1, i);

        T.DFS(0, 0);
    }
}

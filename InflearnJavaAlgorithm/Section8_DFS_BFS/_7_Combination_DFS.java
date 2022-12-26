package Section8_DFS_BFS;

import java.util.Scanner;

public class _7_Combination_DFS {
    static int[][] dy = new int[35][35];

    public int DFS(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];

        if(n==r || r==0) return 1;
        else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        _7_Combination_DFS T = new _7_Combination_DFS();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}

class _7_Combination_DFS_Infleran{
    int[][] dy=new int[35][35];

    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r]=DFS(n-1, r-1)+DFS(n-1, r);
    }

    public static void main(String[] args) {
        _7_Combination_DFS_Infleran T = new _7_Combination_DFS_Infleran();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.DFS(n, r));
    }
}

class _7_Combination_DFS_Practice{
    int[][] memoization = new int[34][34];

    int DFS(int n, int r){
        if(memoization[n][r] != 0) return memoization[n][r];
        if(n == r || r == 0) return 1;
        return DFS(n-1, r-1) + DFS(n-1, r);
    }

    public static void main(String[] args) {
        _7_Combination_DFS_Infleran T = new _7_Combination_DFS_Infleran();
        Scanner sc = new Scanner(System.in);
        System.out.println(T.DFS(sc.nextInt(), sc.nextInt()));
    }
}
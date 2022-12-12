package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _6_Permutation_DFS {
    static int[] number, outPut;

    public void DFS(int level){
        if(level == outPut.length) {
            for(int x : outPut)
                System.out.print(x + " ");
            System.out.println();
        }else {
            for(int i=0; i<number.length; i++){
               outPut[level] = number[i];
               DFS(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        _6_Permutation_DFS T = new _6_Permutation_DFS();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        number = new int[n];
        outPut = new int[m];

        for(int i=0; i<n; i++)
            number[i] = sc.nextInt();

        T.DFS(0);
    }
}

class _6_Permutation_DFS_Inflearn {
    static int[] pm, ch, arr;
    static int n, m;

    public void DFS(int L){
        if(L == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }else {
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        _6_Permutation_DFS_Inflearn T = new _6_Permutation_DFS_Inflearn();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        ch = new int[n];
        pm = new int[m];

        T.DFS(0);
    }
}

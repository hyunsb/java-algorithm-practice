package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;
/**
 * 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 * */
public class _6_Permutation_DFS {
    static int[] number, outPut, check;

    public void DFS(int level){
        if(level == outPut.length) {
            for(int x : outPut)
                System.out.print(x + " ");
            System.out.println();
        }else {
            for(int i=0; i<number.length; i++){
                if(check[i] == 0){
                    check[i] = 1;
                    outPut[level] = number[i];
                    DFS(level + 1);
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        _6_Permutation_DFS T = new _6_Permutation_DFS();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        number = new int[n];
        check = new int[n];
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

class _6_Permutation_DFS_Practice{
    static int n, m;
    static int[] numbers, permutation, check;

    void DFS(int level){
        if(level == m){
            for (int x : permutation)
                System.out.print(x + " ");
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(check[i] == 0){
                check[i] = 1;
                permutation[level] = numbers[i];
                DFS(level+1);
                check[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _6_Permutation_DFS_Practice main = new _6_Permutation_DFS_Practice();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for(int i=0; i<n; i++)
            numbers[i] = sc.nextInt();

        check = new int[n];
        permutation = new int[m];

        main.DFS(0);
    }
}
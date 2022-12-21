package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/**
 * 동전교환
 * </br>
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
 * 해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
 * */

public class _5_Coin_Exchange_DFS {
    static int n, m;
    static int[] coins;
    static int minChangeCoin = Integer.MAX_VALUE;

    public void DFS(int level, int change){
        if(change > m) return;
        if(level > minChangeCoin) return;

        if(change == m){
            minChangeCoin = Math.min(minChangeCoin, level);
            return;
        }

        for(int i=0; i<coins.length; i++){
            DFS(level+1, change + coins[i]);
        }
    }

    public static void main(String[] args) {
        _5_Coin_Exchange_DFS T = new _5_Coin_Exchange_DFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 동전의 종류개수

        coins = new int[n];
        for(int i=0; i<n; i++)
            coins[i] = sc.nextInt();

        m = sc.nextInt(); // 거슬러 줄 금액

        T.DFS(0, 0);
        System.out.println(minChangeCoin);
    }
}

class _5_Coin_Exchange_DFS_Inflearn{
    static int n, m, answer=Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr){
        if(sum>m) return;
        if(L>=answer) return;
        if(sum==m){
            answer=Math.min(answer, L);
        }
        else{
            for(int i=0; i<n; i++){
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args){
        _5_Coin_Exchange_DFS_Inflearn T = new _5_Coin_Exchange_DFS_Inflearn();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0; i<n; i++) arr[i]=kb.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        m=kb.nextInt();
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _5_Coin_Exchange_DFS {
    static int coinTypeNumber;
    static Integer[] coinType;
    static int change;

    static int minCountCoin = Integer.MAX_VALUE;

    public void DFS(int level, int sumOfChange){
        if(sumOfChange > change) return;

        if(level >= minCountCoin) return;

        if(sumOfChange == change){
            minCountCoin = Math.min(minCountCoin, level);
        } else {
            for(int i=0; i<coinTypeNumber; i++){
                DFS(level+1, sumOfChange + coinType[i]);
            }
        }
    }


    public static void main(String[] args) {
        _5_Coin_Exchange_DFS T = new _5_Coin_Exchange_DFS();
        Scanner sc = new Scanner(System.in);

        coinTypeNumber = sc.nextInt();

        coinType = new Integer[coinTypeNumber];
        for(int i=0; i<coinTypeNumber; i++)
            coinType[i] = sc.nextInt();

        Arrays.sort(coinType, Collections.reverseOrder());

        change = sc.nextInt();
        T.DFS(0, 0);
        System.out.println(minCountCoin);
    }
}


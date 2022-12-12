package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _2_Baduki_Riding_DFS {
    static int n, maxWeight, totalWeight = 0;

    public void DFS(int idx, int sum, int[] arr){
        if(sum > maxWeight) return;

        if(idx == n) {
            totalWeight = Math.max(totalWeight, sum);
        } else {
            DFS(idx+1, (sum + arr[idx]), arr);
            DFS(idx+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        _2_Baduki_Riding_DFS T = new _2_Baduki_Riding_DFS();
        Scanner sc = new Scanner(System.in);

        maxWeight = sc.nextInt();
        n = sc.nextInt();
        int[] badukiList = new int[n];
        for(int i=0; i<n; i++)
            badukiList[i] = sc.nextInt();

        T.DFS(0, 0, badukiList);
        System.out.println(totalWeight);
    }
}

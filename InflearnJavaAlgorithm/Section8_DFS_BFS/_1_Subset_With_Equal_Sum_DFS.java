package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _1_Subset_With_Equal_Sum_DFS {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr){
        if(flag) return;
        if(sum > total/2) return;
        if(L==n){
            if( (total-sum) == sum ){
                answer = "YES";
                flag = true;
            }
        }else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        _1_Subset_With_Equal_Sum_DFS T = new _1_Subset_With_Equal_Sum_DFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

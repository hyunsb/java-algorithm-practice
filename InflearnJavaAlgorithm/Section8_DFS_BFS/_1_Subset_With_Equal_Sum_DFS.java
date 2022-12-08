package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _1_Subset_With_Equal_Sum_DFS {
    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS_(int idx, int sum, int[] arr){
        if(flag) return;
        if(sum > total/2) return;

        if(idx == n){
            // 부분집합 생성을 완료한 경우의 수
            if(sum == (total - sum)) {
                answer = "YES";
                flag = true;
            }
        }else {
            // 다음 숫자를 포함하여 부분집합을 생성하는 경우의 수
            DFS_(idx+1, sum + arr[idx], arr);
            // 다음 숫자를 포함하지 않고 부분집합을 생성하는 경우의 수
            DFS_(idx+1, sum, arr);
        }
    }


//    public void DFS(int L, int sum, int[] arr){
//        if(flag) return;
//        if(sum > total/2) return;
//        if(L==n){
//            if( (total-sum) == sum ){
//                answer = "YES";
//                flag = true;
//            }
//        }else {
//            DFS(L+1, sum+arr[L], arr);
//            DFS(L+1, sum, arr);
//        }
//    }

    public static void main(String[] args) {
        _1_Subset_With_Equal_Sum_DFS T = new _1_Subset_With_Equal_Sum_DFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

//        T.DFS(0, 0, arr);
        T.DFS_(0, 0, arr);
        System.out.println(answer);
    }
}

package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _1_Subset_With_Equal_Sum_DFS {
    static int n, sumOfSet = 0;
    static int[] set;
    static boolean flag = false;
    static String answer = "NO";

    public void DFS(int level, int sumOfSubset){
        if(sumOfSubset > sumOfSet / 2) return;
        if(flag) return;
        if(level == n){
            if( (sumOfSet - sumOfSubset) == sumOfSubset) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(level+1, sumOfSubset + set[level]);
            DFS(level+1, sumOfSubset);
        }
    }

    public static void main(String[] args) {
        _1_Subset_With_Equal_Sum_DFS main = new _1_Subset_With_Equal_Sum_DFS();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        set = new int[n];

        for(int i=0; i<n; i++) {
            set[i] = sc.nextInt();
            sumOfSet += set[i];
        }

        main.DFS(0, 0);
        System.out.println(answer);
    }
}

class _1_Subset_With_Equal_Sum_DFS_Inflearn {
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

    public static void main(String[] args) {
        _1_Subset_With_Equal_Sum_DFS_Inflearn T = new _1_Subset_With_Equal_Sum_DFS_Inflearn();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        T.DFS_(0, 0, arr);
        System.out.println(answer);
    }
}

package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;
/**
 * <h3>바둑이 승차(DFS)</h3>
 * 철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태
 * 울수가 없다. 철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.
 * N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운
 * 무게를 구하는 프로그램을 작성하세요.
 * </br>
 * ▣ 입력설명
 * 첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.
 * 둘째 줄부터 N마리 바둑이의 무게가 주어진다.
 * </br>
 * ▣ 출력설명
 * 첫 번째 줄에 가장 무거운 무게를 출력한다.
 * </br>
 * ▣ 입력예제
 * 259 5
 * 81
 * 58
 * 42
 * 33
 * 61
 * </br>
 * ▣ 출력예제
 * 242
 * */

public class _2_Baduki_Riding_DFS {
    private static int limitWeight;
    private static int maxWeight;
    private static int[] baduks;

    void DFS(int level, int sumOfWeight){
        if(sumOfWeight > limitWeight)
            return;

        if(level == baduks.length) {
            maxWeight = Math.max(maxWeight, sumOfWeight);
        }else {
            DFS(level+1, sumOfWeight + baduks[level]);
            DFS(level+1, sumOfWeight);
        }
    }

    public static void main(String[] args) {
        _2_Baduki_Riding_DFS main = new _2_Baduki_Riding_DFS();
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();

        limitWeight = c;
        maxWeight = Integer.MIN_VALUE;

        baduks = new int[n];
        for(int i=0; i<baduks.length; i++)
            baduks[i] = sc.nextInt();

        main.DFS(0, 0);
        System.out.println(maxWeight);
    }
}


class _2_Baduki_Riding_DFS_Inflearn {
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
        _2_Baduki_Riding_DFS_Inflearn T = new _2_Baduki_Riding_DFS_Inflearn();
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

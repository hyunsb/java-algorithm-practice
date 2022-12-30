package Section10_Dynamic_Programming;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * <h3>최대 부분 증가수열</h3>
 * N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰
 * 수로) 원소들의 집합을 찾는 프로그램을 작성하라. 예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7,
 * 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어 길
 * 이가 5인 최대 부분 증가수열을 만들 수 있다.
 * @입력설명:
 * 첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,
 * 둘째 줄은 N개의 입력데이터들이 주어진다.
 * @출력설명:
 * 첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.
 * @입력예제:
 * 8
 * 53786294
 * @출력예제:
 * 4
 * */

public class _3_Maximum_Partial_Increment_Sequence {
    static int[] arr, dp;

    public int solution(int n){
        int answer = 0;
        dp[0] = 1;
        for(int i=1; i<n; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        _3_Maximum_Partial_Increment_Sequence main = new _3_Maximum_Partial_Increment_Sequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        System.out.println(main.solution(n));
    }
}

//==================Inflearn Code===================//
class _3_Maximum_Partial_Increment_Sequence_Inflearn{
    static int[] arr, dy;
    public static void main(String[] args) {
        
    }
}
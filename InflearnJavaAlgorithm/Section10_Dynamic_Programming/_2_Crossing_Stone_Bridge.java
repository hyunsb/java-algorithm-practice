package Section10_Dynamic_Programming;

import java.util.Scanner;

/**
 * <h2>돌다리 건너기</h2>
 * 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다. 철
 * 수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
 * 철수가 개울을 건너는 방법은 몇 가지일까요?
 * @입력설명:
 * 첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.
 * @출력설명:
 * 첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.
 * @입력예제:
 * 7
 * @출력예제:
 * 34
 * */
public class _2_Crossing_Stone_Bridge {
    static int[] dp;
    public void solution(){
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++)
            dp[i] = dp[i-1] + dp[i-2];
    }

    public static void main(String[] args) {
        _2_Crossing_Stone_Bridge main = new _2_Crossing_Stone_Bridge();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+2];
        main.solution();
        System.out.println(dp[dp.length-1]);
    }
}

//=====================Inflearn Code====================//

class _2_Crossing_Stone_Bridge_Inflearn{
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;
        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }
        return dy[n+1];
    }
    public static void main(String[] args) {
        _2_Crossing_Stone_Bridge_Inflearn T = new _2_Crossing_Stone_Bridge_Inflearn();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+2];
        System.out.println(T.solution(n));
    }
}
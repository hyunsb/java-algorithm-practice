package Section10_Dynamic_Programming;
import java.util.*;

/**
 * <h2>동전교환(냅색 알고리즘)</h2>
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환
 * 해주려면 어떻게 주면 되는가? 각 단위의 동전은 무한정 쓸 수 있다.
 * @입력설명:
 * 첫 번째 줄에는 동전의 종류개수 <span color="white">N(1<=N<=50)</span>이 주어진다. 두 번째 줄에는 N개의 동전의 종
 * 류가 주어지고, 그 다음줄에 거슬러 줄 금액 <span color="white">M(1<=M<=500)</span>이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 * @출력설명:
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 * @입력예제:
 * 3 <br>
 * 125<br>
 * 15<br>
 * @출력예제:
 * 3
 * */

public class _5_Coin_Exchange {

    public int solution(int[] coins, int[] dp){
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<dp.length; j++){
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        _5_Coin_Exchange main = new _5_Coin_Exchange();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];
        for(int i=0; i<coins.length; i++)
            coins[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] dp = new int[m+1];

        System.out.println(main.solution(coins, dp));
    }
}

//=================Inflearn Code=========================//

class _5_Coin_Exchange_Inflearn{
    static int n, m;
    static int[] dy;
    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                dy[j]=Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args){
        _5_Coin_Exchange_Inflearn T = new _5_Coin_Exchange_Inflearn();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        m=kb.nextInt();
        dy=new int[m+1];
        System.out.print(T.solution(arr));
    }
}
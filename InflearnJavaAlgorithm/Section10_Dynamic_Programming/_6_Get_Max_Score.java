package Section10_Dynamic_Programming;
import java.util.*;

/**
 * <h2>최대점수 구하기(냅색 알고리즘)</h2>
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를
 * 풀려고 합니다. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩
 * 니다. 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다. (해당문제는
 * 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * @입력설명:
 * 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다. <br>
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 * @출력설명:
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 * @입력예제:
 * 5 20<br>
 * 10 5<br>
 * 25 12<br>
 * 15 8<br>
 * 63<br>
 * 74<br>
 * @출력예제:
 * 41
 */

public class _6_Get_Max_Score{
    public static void main(String[] args) {
        _6_Get_Max_Score main = new _6_Get_Max_Score();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[m+1];
        for(int i=0; i<n; i++){
            int score = sc.nextInt();
            int time = sc.nextInt();

            for(int j=m; j>=time; j--){
                dp[j] = Math.max(dp[j], dp[j-time] + score);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}

//==================Inflearn Code===================//

class _6_Get_Max_Score_Inflearn {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] dy=new int[m+1];
        for(int i=0; i<n; i++){
            int ps=kb.nextInt();
            int pt=kb.nextInt();
            for(int j=m; j>=pt; j--){
                dy[j]=Math.max(dy[j], dy[j-pt]+ps);
            }
        }
        System.out.print(dy[m]);
    }
}

//==================Practice Code===================//

// 풀 수 있는 문제, 보석 담기문제의 보석 등등의 자원을 중복으로 담을 수 있을 경우에는 정순으로 DP 시행
// 중복이 불가능한 경우 역순으로 DP 시행

class _6_Get_Max_Score_Practice{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] maxScore = new int[m+1]; // maxScore[idx] 는 idx 시간이 주어졌을 때 얻을 수 있는 최대 점수

        for(int i=0; i<n; i++){
            int questionScore = sc.nextInt();
            int questionTime = sc.nextInt();

            for(int j=maxScore.length-1; j>=questionTime; j--){
                maxScore[j] = Math.max(maxScore[j], maxScore[j-questionTime] + questionScore);
            }
        }
        System.out.println(maxScore[maxScore.length-1]);
    }
}
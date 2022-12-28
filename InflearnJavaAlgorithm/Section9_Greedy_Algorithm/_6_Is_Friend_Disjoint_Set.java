package Section9_Greedy_Algorithm;

import java.util.Scanner;

/**
 * <h2 color="#446FC1">친구인가? (Disjoint-Set : Union&Find)</h2>
 * <p color="grey">오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각
 * 학생들의 친구관계를 알고 싶다.
 * 모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계
 * 가 번호로 표현된 숫자쌍이 주어진다. 만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학
 * 생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.
 * 그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.
 * 학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램
 * 을 작성하세요. 두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.</p>
 * <br><br>
 * <h3 color="9C9C9C">▣입력설명</h3>
 * 첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이
 * 주어지고, 다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.
 * 마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.
 * <br><br>
 * <h3 color="9C9C9C">▣출력설명</h3>
 * 첫 번째 줄에 “YES"또는 "NO"를 출력한다.
 * */


public class _6_Is_Friend_Disjoint_Set {
    static int[] friendTreeNums; // 배열의 인덱스 번호는 학생 번호, 배열 각 인덱스 값은 친구 트리의 번호

    static int Find(int studentNum){
        if(studentNum == friendTreeNums[studentNum])
            return friendTreeNums[studentNum];
        else return friendTreeNums[studentNum] = Find(friendTreeNums[studentNum]);
    }

    // 친구관계를 저장하는 메서드
    static void Union(int student, int friend){
        // 각 파라매터의 친구 트리의 번호를 저장
        int studentTreeNum = Find(student);
        int friendTreeNum = Find(friend);

        // 친구 트리의 번호가 같지 않다면, 같은 번호로 초기화
        if(studentTreeNum != friendTreeNum)
            friendTreeNums[studentTreeNum] = friendTreeNum;
    }

    public static void main(String[] args) {
        _6_Is_Friend_Disjoint_Set main = new _6_Is_Friend_Disjoint_Set();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 학생의 친구 트리가 형성되기 이전이기 때문에 트리의 번호는 각 학생의 번호로 초기화
        friendTreeNums = new int[n+1];
        for(int i=1; i<=n; i++)
            friendTreeNums[i] = i;

        for(int i=0; i<m; i++){
            int student = sc.nextInt();
            int friend = sc.nextInt();
            Union(student, friend);
        }

        if(Find(sc.nextInt()) != Find(sc.nextInt()))
            System.out.println("NO");
        else System.out.println("YES");
    }
}

//==========================Inflearn Code========================//

class _6_Is_Friend_Disjoint_Set_Inflearn {
    static int[] unf; // 배열의 인덱스 번호는 학생 번호, 배열 각 인덱스 값은 집합의 번호

    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        _6_Is_Friend_Disjoint_Set_Inflearn T = new _6_Is_Friend_Disjoint_Set_Inflearn();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n+1];
        for(int i=1; i<=n; i++) unf[i] = i;

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }
}
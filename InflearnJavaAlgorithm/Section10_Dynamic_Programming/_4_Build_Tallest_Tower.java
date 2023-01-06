package Section10_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * <h2>가장 높은 탑 쌓기</h2>
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래
 * 에서 위로 쌓으면서 만들어 간다. 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프
 * 로그램을 작성하시오.<br>
 * (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다. <br>
 * (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다. <br>
 * (조건3) 벽돌들의 높이는 같을 수도 있다.<br>
 * (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다. <br>
 * (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.<br>
 * @입력설명:
 * 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대
 * 100개이다. 둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높
 * 이 그리고 무게가 차례대로 양의 정수로 주어진다. 각 벽돌은 입력되는 순서대로 1부터 연속
 * 적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.
 * @출력설명:
 * 첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.
 * @입력예제:
 * 5 <br>
 * 25 3 4 <br>
 * 4 4 6<br>
 * 9 2 3<br>
 * 16 2 5<br>
 * 1 5 2<br>
 * @출력예제:
 * 10
 * */



class Brick_Info implements Comparable<Brick_Info>{
    int area; // 밑면의 넓이
    int height; // 높이
    int weight; // 넓이

    Brick_Info(int area, int height, int weight){
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    // 밑면의 넓이 기준 오름차순으로 정렬
    @Override
    public int compareTo(Brick_Info o) {
        return o.area - this.area;
    }
}

public class _4_Build_Tallest_Tower{

    public int solution(ArrayList<Brick_Info> bricks){
        int dp[] = new int[bricks.size()]; // 각 인덱스 값에 해당하는 벽돌로 탑을 쌓았을 때의 탑의 높이를 저장하는 배열
        Collections.sort(bricks); // 밑면의 넓이 기준 오름차순으로 정렬
        dp[0] = bricks.get(0).height;

        // 현재 벽돌을 선택하여 탑을 쌓을 때의 탑의 높이를 저장한다.
        for(int i=1; i<bricks.size(); i++){
            int max_height = 0;
            for(int j=i-1; j>=0; j--){
                if(bricks.get(i).weight < bricks.get(j).weight){
                    max_height = Math.max(max_height, dp[j] + bricks.get(i).height);
                }
            }
            dp[i] = max_height;
        }

        // 가장 큰 높이를 반환한다.
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        _4_Build_Tallest_Tower main = new _4_Build_Tallest_Tower();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Brick_Info> bricks = new ArrayList<>();
        for(int i=0; i<n; i++)
            bricks.add(new Brick_Info(sc.nextInt(), sc.nextInt(), sc.nextInt()));

        System.out.println(main.solution(bricks));
    }
}

//===================Inflearn Code======================//

class Brick implements Comparable<Brick>{
    public int s, h, w;
    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o){
        return o.s-this.s;
    }
}

class _4_Build_Tallest_Tower_Inflearn {
    static int[] dy;
    public int solution(ArrayList<Brick> arr){
        int answer=0;
        Collections.sort(arr);
        dy[0]=arr.get(0).h;
        answer=dy[0];
        for(int i=1; i<arr.size(); i++){
            int max_h=0;
            for(int j=i-1; j>=0; j--){
                if(arr.get(j).w > arr.get(i).w && dy[j]>max_h){
                    max_h=dy[j];
                }
            }
            dy[i]=max_h+arr.get(i).h;
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        _4_Build_Tallest_Tower_Inflearn T = new _4_Build_Tallest_Tower_Inflearn();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        ArrayList<Brick> arr=new ArrayList<>();
        dy=new int[n];
        for(int i=0; i<n; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.print(T.solution(arr));
    }
}
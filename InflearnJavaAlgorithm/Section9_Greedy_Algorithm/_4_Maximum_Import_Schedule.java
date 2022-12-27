package Section9_Greedy_Algorithm;

import java.util.*;
/**
 * <h3>최대 수입 스케쥴(PriorityQueue 응용문제)</h3>
 * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강
 * 연을 해 주면 M만큼의 강연료를 주기로 했다.
 * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
 * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
 * <br><br>
 * @▣입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과
 * D(1<=D<=10,000)가 차례로 주어진다.
 * <br><br>
 * @▣출력설명
 * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
 * */
class LectureInfo implements Comparable<LectureInfo>{
    int pay, day;

    LectureInfo(int pay, int day){
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(LectureInfo o) {
        return o.day - this.day;
    }
}

public class _4_Maximum_Import_Schedule {
    public int solution(ArrayList<LectureInfo> lectureInfos){
        int answer = 0;
        Collections.sort(lectureInfos);
        int date = lectureInfos.get(0).day;

        PriorityQueue<Integer> payList = new PriorityQueue<>(Collections.reverseOrder());

//        System.out.println(date);
//        for(LectureInfo ob : lectureInfos)
//            System.out.println(ob.pay + " " + ob.day);


        int j = 0;
        for(int i = date; i >= 1; i--){
            for( ; j<lectureInfos.size(); j++){
                if(lectureInfos.get(j).day < i) break;
                payList.offer(lectureInfos.get(j).pay);
//                System.out.println(payList);
            }

            if(!payList.isEmpty())
                answer += payList.poll();

//            System.out.println(answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        _4_Maximum_Import_Schedule main = new _4_Maximum_Import_Schedule();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<LectureInfo> lectureInfos = new ArrayList<>();
        for(int i=0; i<n; i++)
            lectureInfos.add(new LectureInfo(sc.nextInt(), sc.nextInt()));

        System.out.println(main.solution(lectureInfos));
    }
}

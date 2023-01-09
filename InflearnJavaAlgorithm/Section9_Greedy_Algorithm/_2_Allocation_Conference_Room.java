package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <h2>회의실 배정</h2>
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들
 * 려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하
 * 면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중
 * 단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * @입력설명:
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정
 * 보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 회의 시간은 0시부터 시작된다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 * @출력설명:
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 * @입력예제:
 * 5 <br>
 * 14<br>
 * 23<br>
 * 35<br>
 * 46<br>
 * 57<br>
 * @출력예제:
 * 3
 * */
class ConferenceInfo implements Comparable<ConferenceInfo>{
    int start, end;
    ConferenceInfo(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ConferenceInfo o) {
        if(this.end == o.end)
            return this.start - o.start;
        else return this.end - o.end;
    }
}

public class _2_Allocation_Conference_Room {
    public int solution(List<ConferenceInfo> conferenceList){
        int answer = 0;
        Collections.sort(conferenceList);

        int tempEnd = Integer.MAX_VALUE;
        for(ConferenceInfo con : conferenceList){
            if(con.end < tempEnd){
                tempEnd = con.end;
                answer++;
            }

            if(tempEnd <= con.start){
                tempEnd = con.end;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _2_Allocation_Conference_Room main = new _2_Allocation_Conference_Room();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<ConferenceInfo> conferenceList = new ArrayList<>();
        for(int i=0; i<n; i++)
            conferenceList.add(new ConferenceInfo(sc.nextInt(), sc.nextInt()));

//        for(ConferenceInfo ob : conferenceList)
//            System.out.println(ob.start + " : " + ob.end);
        System.out.println(main.solution(conferenceList));
    }
}

//============================Inflearn Code=====================================//

class Time implements Comparable<Time>{
    public int s, e;
    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if(this.e == o.e) return this.s - o.s;
        else return this.e - o.e;
    }
}
class _2_Allocation_Conference_Room_Inflearn{
    public int solution(ArrayList<Time> arr, int n){
        int cnt = 0;
        Collections.sort(arr);
        int et=0;
        for(Time ob : arr){
            if(ob.s >= et){
                cnt++;
                et = ob.e;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        _2_Allocation_Conference_Room_Inflearn T = new _2_Allocation_Conference_Room_Inflearn();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }
        System.out.println(T.solution(arr, n));
    }
}

//===========================Practice Code===========================//
class _2_Allocation_Conference_Room_Practice{
    public int solution(ArrayList<ConferenceInfo> conferenceInfos){
        int answer = 0;
        Collections.sort(conferenceInfos);
        int startTime = Integer.MIN_VALUE;
        for(ConferenceInfo conferenceInfo : conferenceInfos){
            if(conferenceInfo.start >= startTime) {
                answer++;
                startTime = conferenceInfo.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _2_Allocation_Conference_Room_Practice main = new _2_Allocation_Conference_Room_Practice();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ConferenceInfo> conferenceInfos = new ArrayList<>();
        for(int i=0; i<n; i++)
            conferenceInfos.add(new ConferenceInfo(sc.nextInt(), sc.nextInt()));
        System.out.println(main.solution(conferenceInfos));
    }
}
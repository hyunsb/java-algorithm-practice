package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
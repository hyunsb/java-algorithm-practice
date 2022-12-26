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

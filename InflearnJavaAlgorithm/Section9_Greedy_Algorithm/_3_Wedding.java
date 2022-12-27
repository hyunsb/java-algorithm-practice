package Section9_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

class AttendInfo implements Comparable<AttendInfo>{
    int time;
    char separation;

    AttendInfo(int time, char separation){
        this.time = time;
        this.separation = separation;
    }

    @Override
    public int compareTo(AttendInfo o) {
        if(this.time == o.time)
            return this.separation - o.separation;
        else return this.time - o.time;
    }
}

public class _3_Wedding {
    public int solution(ArrayList<AttendInfo> attendInfos){
        Collections.sort(attendInfos);
        int count = 0;
        int answer = Integer.MIN_VALUE;

        for(AttendInfo ob : attendInfos){
            if(ob.separation == 's') count++;
            else count--;

            answer = Math.max(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        _3_Wedding main = new _3_Wedding();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<AttendInfo> attendInfos = new ArrayList<>();

        for(int i=0; i<n; i++){
            attendInfos.add(new AttendInfo(sc.nextInt(), 's'));
            attendInfos.add(new AttendInfo(sc.nextInt(), 'e'));
        }

        System.out.println(main.solution(attendInfos));
    }
}
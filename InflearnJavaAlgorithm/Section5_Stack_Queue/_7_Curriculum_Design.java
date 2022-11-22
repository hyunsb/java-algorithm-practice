package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7_Curriculum_Design {
    public static void main(String[] args) {
        _7_Curriculum_Design T = new _7_Curriculum_Design();
        Scanner sc = new Scanner(System.in);

        String curriculum = sc.next();
        String timeTable = sc.next();
        System.out.println(T.solution(curriculum, timeTable));
    }

    private final String YES = "YES";
    private final String NO = "NO";
    public String solution(String curriculum, String timeTable){
        Queue<String> timeQueue = new LinkedList<>();
        for(String s : timeTable.split("")){
            if(curriculum.contains(s))
                timeQueue.offer(s);
        }

        StringBuilder tmp = new StringBuilder();
        for(String item : timeQueue)
            tmp.append(item);

        return tmp.toString().equals(curriculum) ? YES : NO;
    }
}

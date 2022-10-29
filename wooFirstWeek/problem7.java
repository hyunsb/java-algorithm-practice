package wooFirstWeek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class problem7 {
    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");

        System.out.println(solution(user, friends, visitors));

    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        //친구 리스트
        //함께 아는 친구 리스트
        //친구 0점, 함께 아는 친구 10점, 모르는 사람 1점

        return answer;
    }

}

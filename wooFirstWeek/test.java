package wooFirstWeek;

import java.util.*;

public class test {
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

    //하드 코딩
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        HashMap<String, List<String>> friendList = new HashMap<String, List<String>>();
        for(List<String> list : friends){
            HashSet<String> set = new HashSet<String>();
            HashSet<String> set2 = new HashSet<String>();

            String name = list.get(0);
            String name2 = list.get(1);

            for(List<String> temp : friends){
                if(temp.contains(name)) {
                    set.add(temp.get(0));
                    set.add(temp.get(1));
                }
                if(temp.contains(name2)){
                    set2.add(temp.get(0));
                    set2.add(temp.get(1));
                }
            }
            set.remove(name);
            set2.remove(name2);

            List<String> tempList = new ArrayList<>(set);
            List<String> tempList2 = new ArrayList<>(set2);

            friendList.put(name, tempList);
            friendList.put(name2, tempList2);
        }
        System.out.println(friendList);
        return answer;
    }
}

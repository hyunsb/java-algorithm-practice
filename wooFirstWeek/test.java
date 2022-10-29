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

        //{andole=[shakevan, donut], jun=[shakevan, donut], shakevan=[andole, jun, mrko], donut=[andole, jun, mrko], mrko=[shakevan, donut]}

        HashMap<String, Integer> scoreList = new HashMap<String, Integer>();

        System.out.println(friendList);

        List<String> userFriends = friendList.get(user);
        for(String str : userFriends){
            scoreList.put(str, 0);
            // str의 친구 리스트에 들어가서 mrko가 없으면 10점추가 mrko가 있으면 0점
            System.out.println(friendList.get(str));

            for(String str2 : friendList.get(str)){
                System.out.println(str2);
                if(str2.equals(user)) break;
                if(!friendList.containsValue(user)){
                    if(scoreList.containsKey(str2)) scoreList.put(str2, scoreList.get(str2) + 10);
                    if(!scoreList.containsKey(str2)) scoreList.put(str2, 10);
                }
            }
        }

        return answer;
    }
}

package wooFirstWeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

        System.out.println(frinedList(friends));


    }

    public static List<String> frinedList(List<List<String>> friends){
        HashSet<String> set = new HashSet<String>();
        for(List<String> friend : friends){
            set.add(friend.get(0));
            set.add(friend.get(1));
        }
        List<String> list = new ArrayList<>(set);
        return list;
    }

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }


}

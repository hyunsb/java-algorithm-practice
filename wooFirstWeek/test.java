package wooFirstWeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args) {

        String user = "mrko";
        List<List<String>> friends = new ArrayList<>();

        List<String> friendsList = new ArrayList<String>(pickFriendsList(user, friends));

    }

    public static List<String> pickFriendsList(String user, List<List<String>> friends){
        List<String> friendsList = new ArrayList<>();

        for(List<String> relationship : friends){
            friendsList.add(pickFriend(user, relationship));
        }

        return friendsList;
    }

    public static String pickFriend(String user, List<String> relationship){
        String friend = "";
        if(relationship.contains(user)){
            relationship.remove(user);
            friend = relationship.get(0);
        }
        return friend;
    }
}

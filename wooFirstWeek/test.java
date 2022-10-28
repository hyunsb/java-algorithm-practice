package wooFirstWeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String str = "제이엠";
        String strchk = "제이제잉에엠";

        for(int i=0; i < str.length()-1; i++){
            System.out.println(strchk.contains(str.substring(i,i+2)));
        }

        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        System.out.println(forms.size());

        HashSet<String> overlapList = new HashSet<String>();
        overlapList.add("dd");
        overlapList.add("dd");
        overlapList.add("cc");
        overlapList.add("ee");

        List<String> list = new ArrayList<>(overlapList);
        System.out.println(list);


    }
}

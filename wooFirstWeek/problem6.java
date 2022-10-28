package wooFirstWeek;

import java.util.List;

public class problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );

        for(int i=0; i<forms.size(); i++){
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);



        }

        //이메일 길이, 도메인 chk

        //닉네임 chk


    }
    public static List<String> solution(List<List<String>> forms){
        List<String> answer = List.of("answer");

        return answer;
    }

    public static boolean eMailChk(String email){

        return true;
    }
}

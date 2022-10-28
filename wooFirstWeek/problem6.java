package wooFirstWeek;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            if(!(isEmail(email))) break;  //이메일 길이, 도메인 check
            if(!(isNickName(name))) break; // 닉네임 길이, 한글 check


        }
    }
    public static List<String> solution(List<List<String>> forms){
        List<String> answer = List.of("answer");

        return answer;
    }

    public static boolean isEmail(String email){
        boolean validation = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);

        if(m.matches() &&  11 <= email.length() && email.length() < 20){
            if (email.split("@")[1].equals("email.com")) validation = true;
        }
        return validation;
    }
    public static boolean isNickName(String nickName){
        return Pattern.matches("^[가-힣]*$", nickName)
                && nickName.length() >= 1 && nickName.length() < 20;
    }
}

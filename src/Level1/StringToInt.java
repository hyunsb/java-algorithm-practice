package Level1;

public class StringToInt {
    public static void main(String[] args) {
        String s = "a234";

        // My solved
        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        int strLen = s.length();
        boolean answer = (strLen == 4 || strLen ==6) ? true:false;
        if(answer == true) answer = (s.replaceAll("[^0-9]","").length() == strLen)? true:false;

        return answer;
    }
}

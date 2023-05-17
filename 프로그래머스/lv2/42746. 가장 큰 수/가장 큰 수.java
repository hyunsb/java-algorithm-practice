import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    public String solution(int[] numbers){
        StringBuilder builder = new StringBuilder();

        List<String> strings = Arrays.stream(numbers)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList());

        int cnt = 0;
        for (String s : strings) {
            if (s.equals("0"))
                cnt++;
        }
        if (cnt == strings.size()){
            return "0";
        }

        strings.stream()
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .forEach(builder::append);

        return builder.toString();
    }
}
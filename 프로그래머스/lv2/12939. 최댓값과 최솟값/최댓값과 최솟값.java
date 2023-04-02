import java.util.Arrays;
class Solution {
    public String solution(String s) {
        
        String[] strArr = s.split(" ");      
        
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(intArr);
        
        return String.valueOf(intArr[0]) + " " + String.valueOf(intArr[(intArr.length)-1]);
    }
}
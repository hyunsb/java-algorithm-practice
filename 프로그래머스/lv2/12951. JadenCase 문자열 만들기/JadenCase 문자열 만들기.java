class Solution {
    public String solution(String s) {      
        
        String[] strArr = s.split("");
        for(int i = 0; i < strArr.length-1; i++){
            strArr[i+1] = (strArr[i].equals(" "))?strArr[i+1].toUpperCase():strArr[i+1].toLowerCase();
        }
        strArr[0] = strArr[0].toUpperCase();
        String answer = String.join("", strArr);
        
        return String.join("", strArr);
    }
}
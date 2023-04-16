class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String str = s;
        int count = 0;
        int remove = 0;
        boolean flag = true;
        
        while(flag){
            int sLen = str.replaceAll("0", "").length();
            remove += str.length() - sLen;
            str = (Integer.toBinaryString(sLen)).toString();
            count ++;

            flag = str.equals("1") ? false : true;
        }
        
        answer[0] = count;
        answer[1] = remove;
        
        return answer;
    }
}
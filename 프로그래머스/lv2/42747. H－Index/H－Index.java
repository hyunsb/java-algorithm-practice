import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        int value = citations[citations.length-1];
        
        for(int i = value; i>=0; i--){
            int temp = i;
            int count = 0;
            
            for(int n : citations){
                if(temp <= n) count++;
            }
            
            if(temp <= count && citations.length - count <= count) return temp;
        }
        
        return answer;
    }
}
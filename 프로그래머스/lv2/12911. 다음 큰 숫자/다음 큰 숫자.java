class Solution {
    public int solution(int n) {
        int answer = n;
        int count = Integer.bitCount(n);
        
        while (true){
            answer++;
            if (Integer.bitCount(answer) == count) return answer;
        }
    }
}
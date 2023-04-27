class Solution {
    static int[] musketeers = new int[3];
    static int answer = 0;

    public int solution(int[] number){
        DFS(0, 0, number);
        return answer;
    }

    public void DFS(int level, int num, int[] number){
        if(level == 3) {
            int sum = 0;
            for(int x : musketeers)
                sum += x;

            if(sum == 0) answer++;
            return;
        }else {
            for(int i=num; i<number.length; i++){
                musketeers[level] = number[i];
                DFS(level+1, i+1, number);
            }
        }
    }
}
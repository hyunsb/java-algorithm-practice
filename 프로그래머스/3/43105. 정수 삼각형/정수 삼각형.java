class Solution {
    public int solution(int[][] triangle) {
        int[][] temp= triangle.clone();
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                int left = 0;
                if (j != 0) {
                    left = temp[i-1][j-1];
                }
                
                int right = 0;
                if (j != triangle[i].length - 1) {
                    right = temp[i-1][j];
                }
                
                
                temp[i][j] = Integer.max(left, right) + temp[i][j];
            }
        }
        
        int answer = 0;
        for (int sum : temp[temp.length - 1]) {
            answer = Integer.max(answer, sum);
        }
        return answer;
    }
}
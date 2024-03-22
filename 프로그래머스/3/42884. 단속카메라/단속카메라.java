import java.util.*;

class Solution {
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int cam = -30000;
        for (int[] route : routes) {
            if(cam < route[0]) {
                cam = route[1];
                answer += 1;
            }
        }
        
        return answer;
    }
}
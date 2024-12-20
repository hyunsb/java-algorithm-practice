class Solution {
    
    private static final int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        boolean[][] isPuddle = new boolean[n+1][m+1];
        for (int[] puddle : puddles) {
            int x = puddle[1];
            int y = puddle[0];
            isPuddle[x][y] = true;
        }
        
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1; // start
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                
                if (isPuddle[i][j]) continue;
                map[i][j] += map[i-1][j] + map[i][j-1];
                
                map[i][j] %= MOD;
            }
        }
        
        return map[n][m];
    }
}
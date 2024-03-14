import java.util.HashSet;
import java.util.Set;

class Solution {

    static int[] parents;
    
    // [
    // [1, 1, 0], 
    // [1, 1, 0], 
    // [0, 0, 1]
    // ]

    public int solution(int n, int[][] computers) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i==j) continue;
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> group = new HashSet<>();
        for (int i = 0; i < n; i++) {
            group.add(find(i));
        }
        return group.size();
    }
    
    public int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parents[x] = y;
    }
}
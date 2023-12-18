package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Memo {

    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        memo = new int[n+1];
        for (int i = 1; i < n; i++) {
            System.out.println(DFS(i));
        }
    }

    public static int DFS(int n) {
        if (memo[n] != 0) return memo[n];
        if (n == 2 || n == 1) return memo[n] = 1;
        else return memo[n] = DFS(n-2) + DFS(n-1);
    }
}


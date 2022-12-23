package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.Scanner;

public class _14_Island_DFS {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int[][] map;
    static int islandCount = 0;

    void DFS(int x, int y){
        map[x][y] = 0;

        for(int axis=0; axis<dx.length; axis++){
            int nx = x + dx[axis];
            int ny = y + dy[axis];

            try {
                if(map[nx][ny] == 1){
                    map[nx][ny] = 0;
                    DFS(nx, ny);
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {}
        }
    }

    public static void main(String[] args) {
        _14_Island_DFS main = new _14_Island_DFS();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(map[i][j] == 1){
                    islandCount++;
                    main.DFS(i, j);
                }


        System.out.println(islandCount);
    }
}

package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Island{
    public int x, y;

    Island(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class _13_Island_BFS {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static int islandCount = 0;
    static Queue<Island> queue = new LinkedList<>();

    void BFS(){
        while (!queue.isEmpty()){
            Island island = queue.poll();
            for(int axis = 0; axis < dx.length; axis++){
                int nx = island.x + dx[axis];
                int ny = island.y + dy[axis];

                try {
                    if(map[nx][ny] == 1){
                        map[nx][ny] = 0;
                        queue.offer(new Island(nx, ny));
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {}
            }
        }
    }

    public static void main(String[] args) {
        _13_Island_BFS main = new _13_Island_BFS();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    islandCount++;
                    queue.offer(new Island(i, j));
                    main.BFS();
                }
            }
        }

        System.out.println(islandCount);
    }
}

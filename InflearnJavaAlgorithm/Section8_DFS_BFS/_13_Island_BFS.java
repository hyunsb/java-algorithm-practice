package Section8_DFS_BFS;

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

class _13_Island_BFS_Inflearn {
    static int answer=0, n;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();
    public void BFS(int x, int y, int[][] board){
        queue.add(new Point(x, y));
        while(!queue.isEmpty()){
            Point pos = queue.poll();
            for(int i=0; i<8; i++){
                int nx=pos.x+dx[i];
                int ny=pos.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                    board[nx][ny]=0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args){
        _13_Island_BFS_Inflearn T = new _13_Island_BFS_Inflearn();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=kb.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}

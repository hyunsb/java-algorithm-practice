package Section8_DFS_BFS;

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

class _14_Island_DFS_Inflearn{
    static int answer=0, n;
    static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
    public void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                board[nx][ny]=0;
                DFS(nx, ny, board);
            }
        }
    }
    public void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args){
        _14_Island_DFS_Inflearn T = new _14_Island_DFS_Inflearn();
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

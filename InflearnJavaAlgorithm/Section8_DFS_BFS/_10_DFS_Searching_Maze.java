package InflearnJavaAlgorithm.Section8_DFS_BFS;
import java.util.*;

public class _10_DFS_Searching_Maze{
    public static void main(String[] args) {

    }
}

class _10_DFS_Searching_Maze_Inflearn {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board;
    static int answer=0;

    public void DFS(int x, int y){
        if(x==7 && y==7) answer++;
        else{
            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    DFS(nx, ny);
                    board[nx][ny]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        _10_DFS_Searching_Maze_Inflearn T = new _10_DFS_Searching_Maze_Inflearn();
        Scanner kb = new Scanner(System.in);
        board=new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j]=kb.nextInt();
            }
        }
        board[1][1]=1;
        T.DFS(1, 1);
        System.out.print(answer);
    }
}
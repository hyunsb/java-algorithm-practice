package InflearnJavaAlgorithm.Section8_DFS_BFS;
import java.util.*;

/**
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 출발 0  0  0  0  0  0
 *  0  1  1  1  1  1  0
 *  0  0  0  1  0  0  0
 *  1  1  0  1  0  1  1
 *  1  1  0  0  0  0  1
 *  1  1  0  1  1  0  0
 *  1  0  0  0  0  0 도착
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 * */

public class _10_DFS_Searching_Maze{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] maze;
    static int caseCount;

    void DFS(int x, int y){
        if(x==7 && y==7){
            caseCount++;
            return;
        }

        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if( 1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && maze[nx][ny] == 0){
                maze[nx][ny] = 1;
                DFS(nx, ny);
                maze[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _10_DFS_Searching_Maze main = new _10_DFS_Searching_Maze();
        Scanner sc = new Scanner(System.in);

        maze = new int[8][8];
        for(int i=1; i<maze.length; i++)
            for(int j=1; j<maze.length; j++)
                maze[i][j] = sc.nextInt();

        maze[1][1] = 1;
        main.DFS(1, 1);
        System.out.println(caseCount);
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
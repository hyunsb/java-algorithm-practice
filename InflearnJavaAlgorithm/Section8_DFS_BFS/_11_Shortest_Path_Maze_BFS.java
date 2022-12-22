package InflearnJavaAlgorithm.Section8_DFS_BFS;
import java.util.*;

public class _11_Shortest_Path_Maze_BFS {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board, dis;

    public void BFS(int x, int y){
        Queue<Point> Q=new LinkedList<>();
        Q.offer(new Point(x, y));
        board[x][y]=1;
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        _11_Shortest_Path_Maze_BFS T = new _11_Shortest_Path_Maze_BFS();
        Scanner kb = new Scanner(System.in);
        board=new int[8][8];
        dis=new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j]=kb.nextInt();
            }
        }
        T.BFS(1, 1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}

class Point{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class _11_Shortest_Path_Maze_DFS{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze = new int[7][7];
    static int minDist = Integer.MAX_VALUE;

    _11_Shortest_Path_Maze_DFS(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<maze.length; i++)
            for(int j=0; j<maze.length; j++)
                maze[i][j] = sc.nextInt();

        maze[0][0] = 1;
        DFS(0, 0, 0);

        if(minDist == Integer.MAX_VALUE)
            minDist = -1;
        System.out.println(minDist);
    }

    public void DFS(int x, int y, int CurrentDist){
        if(CurrentDist > minDist)
            return;

        if(x==6 && y==6) {
            minDist = Math.min(minDist, CurrentDist);
            return;
        }

        for(int axis = 0; axis < dx.length; axis++){
            try {
                int nx = x + dx[axis];
                int ny = y + dy[axis];
                if(maze[nx][ny] == 0){
                    maze[nx][ny] = 1;
                    DFS(nx, ny, CurrentDist + 1);
                    maze[nx][ny] = 0;
                }
            } catch (ArrayIndexOutOfBoundsException ignore){}
        }
    }

    public static void main(String[] args) {
        _11_Shortest_Path_Maze_DFS main = new _11_Shortest_Path_Maze_DFS();
    }
}

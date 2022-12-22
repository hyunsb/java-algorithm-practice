package InflearnJavaAlgorithm.Section8_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Square{
    public int x, y;

    Square(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class _12_Tomato_BFS {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    static int[][] wareHouse, tomatoDate;
    static Queue<Square> queue = new LinkedList<>();

    public _12_Tomato_BFS(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        wareHouse = new int[n][m];
        tomatoDate = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                wareHouse[i][j] = sc.nextInt();
                if(wareHouse[i][j] == 1)
                    queue.offer(new Square(i, j));
            }
        }

        BFS();

        int maxDate = Integer.MIN_VALUE;
        boolean flag = true;

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(wareHouse[i][j] == 0)
                    flag = false;

        if(flag){
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++){
                    maxDate = Math.max(maxDate, tomatoDate[i][j]);
                }
            System.out.println(maxDate);
        }else System.out.println(-1);
    }

    void BFS(){
        while (!queue.isEmpty()){
            Square currentSquare = queue.poll();
            for(int axis=0; axis < dx.length; axis++){
                int nx = currentSquare.x + dx[axis];
                int ny = currentSquare.y + dy[axis];
                try {
                    if(wareHouse[nx][ny] == 0){
                        wareHouse[nx][ny] = 1;
                        queue.offer(new Square(nx, ny));
                        tomatoDate[nx][ny] = tomatoDate[currentSquare.x][currentSquare.y] + 1;
                    }
                }catch (ArrayIndexOutOfBoundsException ignore){}
            }
        }
    }

    public static void main(String[] args) {
        _12_Tomato_BFS main = new _12_Tomato_BFS();
    }
}

class _12_Tomato_BFS_Inflearn{
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    static int[][] board, dis;
    static int n, m;
    static Queue<Point> Q=new LinkedList<>();
    public void BFS(){
        while(!Q.isEmpty()){
            Point tmp=Q.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        _12_Tomato_BFS_Inflearn T = new _12_Tomato_BFS_Inflearn();
        Scanner kb = new Scanner(System.in);
        m=kb.nextInt();
        n=kb.nextInt();
        board=new int[n][m];
        dis=new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j]=kb.nextInt();
                if(board[i][j]==1) Q.offer(new Point(i, j));
            }
        }
        T.BFS();
        boolean flag=true;
        int answer=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0) flag=false;
            }
        }
        if(flag){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    answer=Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}
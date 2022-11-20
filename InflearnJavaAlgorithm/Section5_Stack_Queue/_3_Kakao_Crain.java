package InflearnJavaAlgorithm.Section5_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class _3_Kakao_Crain {
    //인프런 5-3 크레인 인형뽑기(카카오)
    public static void main(String[] args) {
        _3_Kakao_Crain T = new _3_Kakao_Crain();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) moves[i] = sc.nextInt();

        System.out.println(T.solution(n, board, m, moves));
        System.out.println(T.solution2(board, moves));
    }

    public int solution2(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i=0; i<board.length; i++){
                if(board[i][pos-1]!=0){
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;

                    if(!stack.isEmpty() && tmp == stack.peek()){
                        answer+=2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }


    public int solution(int n, int[][] board, int m, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            for (int j = 0; j < n; j++) {
                if (board[j][move-1] != 0) {
                    basket.push(board[j][move-1]);
                    board[j][move-1] = 0;
                    break;
                }
            }

            int doll = basket.pop();
            if(!basket.isEmpty() && doll == basket.peek()){
                basket.pop();
                answer += 2;
                continue;
            }
            basket.push(doll);
        }
        return answer;
    }
}
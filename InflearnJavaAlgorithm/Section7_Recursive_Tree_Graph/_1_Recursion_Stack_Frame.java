package InflearnJavaAlgorithm.Section7_Recursive_Tree_Graph;

import java.util.Scanner;

public class _1_Recursion_Stack_Frame {
    /**
     * <p>자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성하세요</p>
     *
     * 재귀함수? 백트래킹? 스택프레임?
     * 재귀함수(Recursion): 자기가 자기자신을 호출하는 함수
     *
     * 재귀함수는 스택프레임을 사용한다. (모든 함수는 실행 시 스택에 저장되며 스택프레임이 생성된다.)
     * 스택프레임은 매개변수 주소, 지역변수 주소, 복귀 주소를 가진다.
     *
     * */
    public static void main(String[] args) {
        _1_Recursion_Stack_Frame T = new _1_Recursion_Stack_Frame();
        Scanner sc = new Scanner(System.in);
        T.DFS(sc.nextInt());
    }

    public void DFS(int n){
        if (n==0) return;
        else {
            DFS(n-1);
            System.out.println(n);
        }
    }
}

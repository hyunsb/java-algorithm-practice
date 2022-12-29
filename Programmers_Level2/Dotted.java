package Level2;

import java.util.Scanner;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/140107
 */

public class Dotted {

    public long solution(int k, int d) {
        long answer = 0;
        for(int x=0; x<=d; x+=k){
            int maxY = (int)Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));

            answer += maxY/k + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Dotted main = new Dotted();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int d= sc.nextInt();
        System.out.println(main.solution(k, d));
    }
}

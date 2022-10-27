package woow;

import java.util.List;

public class problem1 {
    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);

        System.out.println(solution(pobi,crong));

        List<Integer> pobi2 = List.of(131, 132);
        List<Integer> crong2 = List.of(211, 212);
        System.out.println(solution(pobi2,crong2));

        List<Integer> pobi3 = List.of(99, 102);
        List<Integer> crong3 = List.of(211, 212);
        System.out.println(solution(pobi3,crong3));

    }

    public static int solution(List<Integer> pobi, List<Integer> crong){
        int answer = Integer.MAX_VALUE;

        if(pobi.get(0) == pobi.get(1)-1 && crong.get(0) == crong.get(1)-1){
            int pobiMax = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
            int crongMax = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));
            if(pobiMax == crongMax) return 0;
            return (pobiMax > crongMax) ? 1 : 2;
        }else{
            return -1;
        }
    }

    public static int findMaxNum(int n) {
        int add = n % 10;
        int mul = n % 10;
        n /= 10;

        while(n > 0) {
            int temp = n % 10;
            add += temp;
            mul *= temp;
            n /= 10;
        }

        return Math.max(add, mul);
    }
}

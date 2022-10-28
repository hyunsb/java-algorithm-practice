package Level2;

import java.util.Arrays;
import java.util.Collections;

public class FindMinArray {
    public static void main(String[] args) {
        // Programmers 연습문제 최솟값 만들기
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        int answer = 0;

        String SD = "Dsadas";
        SD.substring(1, 2);

        int[] arr1 = A;
        Arrays.sort(arr1);

        Integer[] arr2 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i=0; i<arr1.length; i++){
            answer += arr1[i]*arr2[i];
        }

        System.out.println(answer);

        // 실행시간 단축
        int[] arrA = A;
        int[] arrB = B;
        int sol = 0;

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for(int i=0; i<arrA.length; i++){
            sol += arrA[i] * arrB[arrA.length-1-i];
        }

        System.out.println(sol);
    }
}

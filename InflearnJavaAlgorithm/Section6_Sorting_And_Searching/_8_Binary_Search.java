package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class _8_Binary_Search {
    public static void main(String[] args) {
        _8_Binary_Search T = new _8_Binary_Search();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        for(int i=0; i<n; i++) num[i] = sc.nextInt();
        System.out.println(T.solution(n, m, num));
    }

    // 이분검색 - 정렬되어 있는 상태에서만 수행 가능
    public int solution(int n, int m, int[] num){
        Arrays.sort(num);
        int rt = num.length, lt = 0;
        int mid;

        while (true){
            mid = (lt + rt) / 2;
            if(m == num[mid]) return mid+1;
            if(m < num[mid]) rt = mid;
            else if (num[mid] < m) lt = mid;
        }

    }

    public int solution2(int n, int m, int[] num){
        int answer = 0;

        Arrays.sort(num);
        int lt = 0, rt = num.length-1;
        while (lt <= rt){
            int mid = (lt + rt) / 2;

            if(num[mid] == m) {
                answer = mid + 1;
                break;
            }

            if(num[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }

        return answer;
    }
}

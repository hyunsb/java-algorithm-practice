package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class _9_Decision_Algorithm_Music_Video {
    public static void main(String[] args) {
        _9_Decision_Algorithm_Music_Video T = new _9_Decision_Algorithm_Music_Video();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] musicLength = new int[n];
        for(int i=0; i<n; i++) musicLength[i] = sc.nextInt();

        System.out.println(T.solution(n, m, musicLength));
    }

    public int solution(int n, int m, int[] musicLength){
        int lt = Arrays.stream(musicLength).max().getAsInt();
        int rt = Arrays.stream(musicLength).sum();
        int answer = 0;

        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if (count(musicLength, mid) <= m){
                answer = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }

        return answer;
    }

    public int count(int[] arr, int capacity){
        int count = 1;
        int sum = 0;
        for(int i : arr){
            if(sum + i > capacity) {
                count += 1;
                sum = i;
            }
            else sum += i;
        }
        return count;
    }
}

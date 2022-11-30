package InflearnJavaAlgorithm.Section6_Sorting_And_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class _10_Decision_Algorithm_Stable {
    public static void main(String[] args) {
        _10_Decision_Algorithm_Stable T = new _10_Decision_Algorithm_Stable();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] xi = new int[n];
        for(int i=0; i<n; i++) xi[i] = sc.nextInt();
        System.out.println(T.solution(n, c, xi));
    }

    public int solution(int n, int c, int[] xi){
        int answer = 0;
        Arrays.sort(xi);
        int lt = 1;
        int rt = xi[xi.length-1];

        while (lt <= rt){
            int mid = (lt + rt) / 2;
            if (countingHorse(xi, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }

        }
        return answer;
    }

    public int countingHorse(int[] stableCoordinates, int maxDistance){
        int endPoint = stableCoordinates[0], horseCount = 1;
        for(int i=1; i<stableCoordinates.length; i++){
            if(stableCoordinates[i] - endPoint >= maxDistance){
                endPoint = stableCoordinates[i];
                horseCount++;
            }
        }
        return horseCount;
    }
}

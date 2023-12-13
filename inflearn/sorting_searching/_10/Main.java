package inflearn.sorting_searching._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);
        int min = 1, max = arr[n-1];
        int answer = 0;
        while (min < max) {
            int mid = (min + max) / 2;
            int count = 1;

            int endPoint = arr[0];
            for (int i = 0; i <n; i++) {
                if (arr[i] - endPoint >= mid) {
                    count += 1;
                    endPoint = arr[i];
                }
            }
//            System.out.print(mid + " : " + min + " ~ " + max + " = " + count + " ");

            if (count < c) {
//                System.out.println("거리를 좁히자");
                max = mid;
            } else {
//                System.out.println("거리를 늘리자");
                answer = mid;
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

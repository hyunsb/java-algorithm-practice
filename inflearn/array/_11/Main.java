package inflearn.array._11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        System.out.println(solution(arr));
    }

    private static int solution(int[][] arr) {
        int[] count = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            Map<Integer, Integer> classGroups = new HashMap<>();
            boolean[] isSameClass = new boolean[arr.length];

            for (int j = 0; j < arr.length; j++) {
                int classGroup = arr[j][i];
                if (classGroups.containsKey(classGroup)) {
                    isSameClass[classGroups.get(classGroup)] = isSameClass[j] = true;
                } else {
                    classGroups.put(classGroup, j);
                }
            }

            for (int j = 0; j < isSameClass.length; j++) {
                if (isSameClass[j]) {
                    count[j] += 1;
                }
            }
        }

        int maxIndex = 0;
        int maxNumber = count[0];
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            if (maxNumber < count[i]) {
                maxIndex = i;
                maxNumber = count[i];
            }
        }
        return maxIndex + 1;
    }
}

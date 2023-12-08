package inflearn.array._12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = bufferedReader.readLine().split(" ");

        int[][] arr = new int[Integer.parseInt(nm[1])][Integer.parseInt(nm[0])];
        for (int i = 0; i < arr.length; i++) {
            String[] inputs = bufferedReader.readLine().split(" ");
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        solution(arr);
    }

    private static void solution(int[][] arr) {
        Map<Integer, List<Integer>> count = new HashMap<>();
        // 0번째 인덱스 돌면서 나보다 뒤에있는 애들 count에 추가함
        // 다음 인덱스들 돌면서 나보다 앞에 있는 애들 count에 삭제함
        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    int studentNumber = arr[i][j];
                    count.put(studentNumber, new ArrayList<>());
                    for (int k = j; k < arr[i].length; k++) {
                        if (k != j) {
                            count.get(studentNumber).add(arr[i][k]);
                        }
                    }
                }
            }

            else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    int studentNumber = arr[i][j];
                    for (int k = j; k >= 0; k--) {
                        if (k != j) {
                            if (count.get(studentNumber).contains(arr[i][k])){
                                count.get(studentNumber).remove(Integer.valueOf(arr[i][k]));
                            }
                        }
                    }
                }
            }
        }

        // 모든 count 개수 반환하면?
        int answer = 0;
        for (List<Integer> value : count.values()) {
            answer += value.size();
        }
        System.out.println(answer);
    }
}

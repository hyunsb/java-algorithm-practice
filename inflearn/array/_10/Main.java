package inflearn.array._10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(solution(arr));
    }

    private static int solution(int[][] arr) {
        int top = 0;
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

                boolean isTop = true;

                for (int k = 0; k < moveX.length; k++) {

                    int x = moveX[k];
                    int y = moveY[k];

                    try {
                        if (arr[i][j] <= arr[i + x][j + y]) {
                            isTop = false;
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {}
                }

                if (isTop) {
                    top += 1;
                }
            }
        }
        return top;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] arr;
    static int n;
    static int count;

    static void DFS(int depth) {
        if (depth == n) {
            count += 1;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPlayQueen(depth)) {
                DFS(depth + 1);
            }
        }
    }

    static boolean isPlayQueen(int column) {
        for (int i = 0; i < column; i++) {
            if (arr[column] == arr[i]) return false; // 같은 열에 존재함
            if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        DFS(0);
        System.out.println(count);
    }
}
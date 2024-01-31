import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[][] board;
    static int negative, positive, zero;

    private static void division(int x, int y, int size) {
        if (isAllSameNumber(x, y, size)) {
            int number = board[x][y];
            if (number == -1) negative += 1;
            else if (number == 1) positive += 1;
            else if (number == 0) zero += 1;
            return;
        }

        int nextSize = size / 3;
        division(x, y, nextSize);
        division(x, y + nextSize, nextSize);
        division(x, y + nextSize * 2, nextSize);

        division(x + nextSize, y, nextSize);
        division(x + nextSize, y + nextSize, nextSize);
        division(x + nextSize, y + nextSize * 2, nextSize);

        division(x + nextSize * 2, y, nextSize);
        division(x + nextSize * 2, y + nextSize, nextSize);
        division(x + nextSize * 2, y + nextSize * 2, nextSize);
    }

    private static boolean isAllSameNumber(int x, int y, int size) {
        int targetNumber = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (targetNumber != board[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        board = new int[n][n];
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        division(0, 0, n);
        System.out.println(negative + "\n" + zero + "\n" + positive);
    }
}
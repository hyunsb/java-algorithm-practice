import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[][] map = new int[9][9];
    static Position doseNotExistEmptyPosition = new Position(-1, -1);

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] low = bufferedReader.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(low[j]);
            }
        }
        sudoku();
    }

    private static void sudoku() {
        Position position = findBlankPosition();

        if (doseNotExistEmptyPosition.equals(position)) {
            printSudoku();
            System.exit(0);
        }

        for (int number = 1; number <= 9; number++) {
            if (isAvailableNumberToPosition(number, position)) {
                map[position.x][position.y] = number;
                sudoku();
                map[position.x][position.y] = 0;
            }
        }
    }

    private static Position findBlankPosition() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0)
                    return new Position(i, j);
            }
        }
        return doseNotExistEmptyPosition;
    }

    private static class Position {

        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
    }

    private static boolean isAvailableNumberToPosition(int number, Position position) {
        int targetX = position.x;
        int targetY = position.y;

        for (int i = 0; i < 9; i++) {
            if (map[targetX][i] == number || map[i][targetY] == number)
                return false;
        }

        int blockStartX = (targetX / 3) * 3;
        int blockStartY = (targetY / 3) * 3;

        for (int i = blockStartX; i < blockStartX + 3; i++) {
            for (int j = blockStartY; j < blockStartY + 3; j++) {
                if (map[i][j] == number)
                    return false;
            }
        }
        return true;
    }

    private static void printSudoku() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(map[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
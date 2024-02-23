import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int gateNumber = Integer.parseInt(bufferedReader.readLine());
        int airPlainNumber = Integer.parseInt(bufferedReader.readLine());

        parents = new int[gateNumber+1];
        for (int i = 0; i < gateNumber + 1; i++) {
            parents[i] = i;
        }

        int answer = 0;
        while (airPlainNumber-- > 0) {
            int airPlain = Integer.parseInt(bufferedReader.readLine());
            int targetGate = find(airPlain);

            if (targetGate == 0)
                break;

            union(targetGate, targetGate -1);
            answer += 1;
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parents[x] = y;
    }
}
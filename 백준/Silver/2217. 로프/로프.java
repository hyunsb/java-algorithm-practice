import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            int rope = Integer.parseInt(bf.readLine());
            ropes[i] = rope;
        }
        Arrays.sort(ropes);

        int answer = 0;
        int count = n;
        for (int i = 0; i < n; i++) {
            int currentWeight = ropes[i] * (count - i);
            if (answer < currentWeight) {
                answer = currentWeight;
            }
        }
        System.out.println(answer);
    }
}
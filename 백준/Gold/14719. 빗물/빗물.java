import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] map = new int[w];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < w; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < w - 1; i++) {
            int currentH = map[i];

            int leftMaxH = findMaxHigherThan(currentH, 0, i, map);
            int rightMaxH = findMaxHigherThan(currentH, i, w, map);
            
            if (currentH < leftMaxH && currentH < rightMaxH) {
                answer += Math.min(leftMaxH, rightMaxH) - currentH;
            }
        }

        System.out.println(answer);
    }

    private static int findMaxHigherThan(int h, int start, int end, int[] map) {
        int maxH = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            int currentH = map[i];
            if (maxH < currentH) {
                maxH = currentH;
            }
        }

        if (maxH < h) return 0;
        return maxH;
    }
}
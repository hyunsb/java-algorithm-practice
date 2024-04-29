import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int cityNumber = Integer.parseInt(bufferedReader.readLine());

        int[] nextDistance = new int[cityNumber];
        int[] oilCost = new int[cityNumber];

        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cityNumber-1; i++) {
            nextDistance[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < cityNumber; i++) {
            oilCost[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int totalCost = getTotalCost(cityNumber, oilCost, nextDistance);

        System.out.println(totalCost);
    }

    private static int getTotalCost(int cityNumber, int[] oilCost, int[] nextDistance) {
        int totalCost = 0;
        for (int i = 0; i < cityNumber; i++) {
            int cOilCost = oilCost[i];
            int nextCity = i+1;

            for (; nextCity < cityNumber; nextCity++) {
                if (cOilCost > oilCost[nextCity]) {
                    break;
                }
            }

            int cNextDistance = 0;
            for (int j = i; j < nextCity; j++) {
                cNextDistance += nextDistance[j];
            }

            totalCost += (cOilCost * cNextDistance);
            i = nextCity - 1;
        }
        return totalCost;
    }
}
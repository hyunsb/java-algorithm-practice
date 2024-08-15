import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int[] sticks;
    static List<Integer> maxNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        maxNumbers = new ArrayList<>();

        sticks = new int[1001];
        StringTokenizer stringTokenizer;
        int maxWeight = Integer.MIN_VALUE;
        int repeat = n;

        while (repeat-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            sticks[number] = weight;

            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        for (int i = 0; i < sticks.length; i++) {
            if (sticks[i] == maxWeight) {
                maxNumbers.add(i);
            }
        }

        maxNumbers.sort(Integer::compareTo);
        int leftEnd = maxNumbers.get(0);
        int rightStart;
        if (maxNumbers.size() == 1) {
            rightStart = leftEnd;
        } else {
            rightStart = maxNumbers.get(maxNumbers.size() - 1);
        }

        int maxArea = calcMaxArea(maxWeight);
        int leftArea = calcLeftArea(leftEnd);
        int rightArea = calcRightArea(rightStart);

        System.out.println(maxArea + leftArea + rightArea);
    }

    private static int calcMaxArea(int maxWeight) {
        if (maxNumbers.size() == 1) {
            return maxWeight;
        }
        return (maxNumbers.get(maxNumbers.size() - 1) - maxNumbers.get(0) + 1) * maxWeight;
    }

    private static int calcLeftArea(int end) {
        int maxWeight = 0;
        int area = 0;
        for (int i = 0; i < end; i++) {
            int currentWeight = sticks[i];
            if (maxWeight < currentWeight) {
                maxWeight = currentWeight;
            }

            area += maxWeight;
        }
        return area;
    }

    private static int calcRightArea(int start) {
        int maxWeight = 0;
        int area = 0;
        for (int i = sticks.length - 1; i > start; i--) {
            int currentWeight = sticks[i];
            if (maxWeight < currentWeight) {
               maxWeight = currentWeight;
            }

            area += maxWeight;
        }
        return area;
    }
}
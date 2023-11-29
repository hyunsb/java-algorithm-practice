package inflearn.array._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(solution(Integer.parseInt(bufferedReader.readLine()), bufferedReader.readLine().split(" ")));
    }

    private static int solution(int n, String[] input2) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : input2) {
            numbers.add(Integer.parseInt(s));
        }

        int count = 0;
        int tall = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                count += 1;
                tall = numbers.get(i);
            } else {
                if (tall < numbers.get(i)) {
                    count += 1;
                    tall = numbers.get(i);
                }
            }
        }
        return count;
    }
}

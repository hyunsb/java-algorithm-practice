import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] strNums = bufferedReader.readLine().split("");
        List<Integer> nums = new ArrayList<>();

        int zeroCount = 0;
        int total = 0;
        for (String strNum : strNums) {
            if (strNum.equals("0")) {
                zeroCount += 1;
            } else {
                int num = Integer.parseInt(strNum);
                total += num;
                nums.add(num);
            }
        }

        if (zeroCount == 0 || total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        nums.sort(Collections.reverseOrder());
        StringBuilder answer = new StringBuilder();
        for (Integer num : nums) {
            answer.append(num);
        }
        answer.append("0".repeat(Math.max(0, zeroCount)));

        System.out.println(answer);
    }
}
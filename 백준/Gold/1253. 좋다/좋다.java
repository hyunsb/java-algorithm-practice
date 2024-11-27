import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(nums);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];

                if (sum == target) {
                    if (start != i && end != i) {
                        answer += 1;
                        break;
                    }

                    if (start == i) {
                        start += 1;
                    }

                    if (end == i) {
                        end -= 1;
                    }
                }

                if (sum < target) {
                    start += 1;
                }

                if (sum > target) {
                    end -= 1;
                }
            }
        }
        System.out.println(answer);
    }
}
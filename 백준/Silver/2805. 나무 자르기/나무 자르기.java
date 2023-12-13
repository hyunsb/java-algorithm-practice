import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        long h = Long.parseLong(tokenizer.nextToken());
        List<Long> list = new ArrayList<>();
        long min = 0, max = 0;

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Long.parseLong(tokenizer.nextToken()));
            if (max < list.get(i)) max = list.get(i);
        }

        while (min < max) {
            long mid = (min + max) / 2;
            long length = 0;
            for (long l : list) {
                if (l - mid > 0) {
                    length += l - mid;
                }
            }
            if (length < h) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
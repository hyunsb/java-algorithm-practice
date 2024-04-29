import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> sign = new ArrayList<>();

        StringBuilder number = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '-' || c == '+') {
                numbers.add(Integer.parseInt(number.toString()));
                sign.add(c);

                number = new StringBuilder();
                continue;
            }
            number.append(c);
        }
        numbers.add(Integer.parseInt(number.toString()));

        int result = numbers.get(0);
        int sum = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (sign.get(i-1) == '-') {
                result -= sum;
                sum = 0;
                sum += numbers.get(i);

            } else if (sign.get(i-1) == '+') {
                if (sum == 0) {
                    result += numbers.get(i);
                } else {
                    sum += numbers.get(i);

                }
            }
        }
        result -= sum;

        System.out.println(result);
    }
}
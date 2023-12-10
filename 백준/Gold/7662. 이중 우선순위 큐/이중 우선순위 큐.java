import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            int repeat = Integer.parseInt(bufferedReader.readLine());
            TreeMap<Integer, Integer> numbers = new TreeMap<>();

            StringTokenizer stringTokenizer;
            for (int j = 0; j < repeat; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String command = stringTokenizer.nextToken();
                Integer number = Integer.parseInt(stringTokenizer.nextToken());

                if (command.equals("I")) {
                    numbers.put(number, numbers.getOrDefault(number, 0) + 1);
                } else {
                    if (!numbers.isEmpty()) {
                        int value = (number == 1) ? numbers.lastKey() : numbers.firstKey();
                        removeMap(numbers, value);
                    }
                }
            }
            if (numbers.isEmpty()) System.out.println("EMPTY");
            else System.out.println(numbers.lastKey() + " " + numbers.firstKey());
        }
    }

    public static void removeMap(TreeMap<Integer, Integer> map, Integer value) {
        Integer count = map.get(value);
        if (count == 1) map.remove(value);
        else map.put(value, count - 1);
    }
}
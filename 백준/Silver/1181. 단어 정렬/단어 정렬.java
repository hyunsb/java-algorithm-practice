import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = bufferedReader.readLine();

        Set<String> stringSet = new TreeSet<>(Arrays.asList(arr));
        stringSet.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        }).forEach(System.out::println);
    }
}
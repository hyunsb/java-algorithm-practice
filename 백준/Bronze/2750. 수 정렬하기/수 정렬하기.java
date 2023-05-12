import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int roof = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[roof];
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(array);
        for (int i : array)
            System.out.println(i);
    }
}
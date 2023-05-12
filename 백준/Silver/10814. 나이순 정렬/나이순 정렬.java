import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[][] arr = new String[n][2];

        for (int i = 0; i < arr.length; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = str.nextToken();
            arr[i][1] = str.nextToken();
        }

        Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
        for (String[] array : arr){
            System.out.println(array[0] + " " + array[1]);
        }
    }
}
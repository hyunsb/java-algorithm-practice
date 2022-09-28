package Level2;

import java.util.Arrays;
public class ArrayMinMax {
    public static void main(String[] args) {
        String str1 = "1 2 3 4";
        String str2 = "-1 -2 -3 -4";

        String[] strArr = str1.split(" ");

        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(intArr);

        System.out.println(String.valueOf(intArr[0]) + " " +
                String.valueOf(intArr[intArr.length-1]));


    }
}

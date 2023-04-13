import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] counts = new int['Z' - 'A' + 1];
        char[] alphabets = new char['Z' - 'A' + 1];

        String word = bufferedReader.readLine().toUpperCase();

        for (int i = 0; i < alphabets.length; i++)
            alphabets[i] = (char) ('A' + i);

        for (int i = 0; i < word.length(); i++){
            counts[word.charAt(i) - 'A']++;
        }


        int max = -1;
        String popular = "";
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max){
                max = counts[i];
                popular = Character.toString(alphabets[i]);
            } else if (counts[i] == max)
                popular = "?";
        }

        System.out.println(popular);
    }
}

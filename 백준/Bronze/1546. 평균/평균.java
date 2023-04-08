import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int scoreCount = Integer.parseInt(bufferedReader.readLine());
        float[] scores = new float[scoreCount];
        float maxScore = Integer.MIN_VALUE;
        float sumOfNewScore = 0f;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < scores.length; i++){
            scores[i] = Integer.parseInt(stringTokenizer.nextToken());
            maxScore = Math.max(maxScore, scores[i]);
        }

        for (int i = 0; i < scores.length; i++)
            sumOfNewScore += (scores[i] / maxScore) * 100;

        System.out.println(sumOfNewScore/scoreCount);
    }
}
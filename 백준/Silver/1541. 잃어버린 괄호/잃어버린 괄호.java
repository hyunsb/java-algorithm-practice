import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String origin = bufferedReader.readLine();

        String[] removeMinus = origin.split("-");
        int answer = 0;

        for (int i = 0; i < removeMinus.length; i++) {
            if (i == 0) {
                answer += sum(removeMinus[i]);
                continue;
            }
            answer -= sum(removeMinus[i]);
        }
        System.out.println(answer);
    }

    public static int sum(String origin) {
        int sum = 0;
        
        String[] removePlus = origin.split("[+]");
        for (String plus : removePlus) {
            sum += Integer.parseInt(plus);
        }
        return sum;
    }
}
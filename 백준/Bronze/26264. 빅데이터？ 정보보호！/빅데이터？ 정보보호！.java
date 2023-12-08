import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String security = bufferedReader.readLine().replaceAll("bigdata", "");

        if (security.isBlank()) System.out.println("bigdata?");
        else {
            int securityCount = security.length() / 8;
            if (n/2 < securityCount) System.out.println("security!");
            else if (n/2 > securityCount) System.out.println("bigdata?");
            else System.out.println("bigdata? security!");
        }
    }
}
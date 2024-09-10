package 소프티어;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        double currentAvg = 3.8;
        int currentNum = 537;

        System.out.println(currentAvg * currentNum);
    }
}



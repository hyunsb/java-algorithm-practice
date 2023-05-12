import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        Member[] members = new Member[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine());
            members[i] = new Member(Integer.parseInt(str.nextToken()), str.nextToken());
        }

        Arrays.sort(members);
        for (Member member : members)
            System.out.println(member);
    }

    private static class Member implements Comparable<Member> {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }

        @Override
        public int compareTo(Member o) {
            return age - o.age;
        }
    }
}
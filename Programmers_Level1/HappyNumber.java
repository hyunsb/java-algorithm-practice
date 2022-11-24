package Programmers_Level1;

import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber T = new HappyNumber();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(T.getHappyCount(n));
    }

    public int getHappyCount(int n){
        int sum = n, count=0;
        while (sum != 1){
            sum = getSum(sum);
            count+=1;
            if (!isHappyNumber(sum))
                return -1;
        }
        return count;
    }

    public boolean isHappyNumber(int sum){
        return sum != 4;
    }

    public int getSum(int num){
        int sum = 0;

        while (num != 0){
            int temp = num%10;
            sum += temp * temp;
            num /= 10;
        }
        return sum;
    }
}

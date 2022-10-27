package woow;

public class problem3 {
    public static void main(String[] args) {
        int number = 33;
        int count = 0;

        for(int i = 1; i <= number; i++){
            int temp = i;
            while(temp > 0) {
                if (temp % 10 == 3 || temp % 10 == 6 || temp % 10 == 9) count++;
                temp /= 10;
            }
        }
        //test

        System.out.println(count);
    }
}

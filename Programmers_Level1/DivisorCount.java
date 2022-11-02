package Level1;

public class DivisorCount {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int answer1 = 0;

        for(int i=left; i<=right; i++){
            int count = 0;
            for(int j=1; j<=i; j++){
                if(i%j==0) count++;
            }
            answer1 += (count%2==0)?i:-i;
        }

        int answer2 = 0;
        for(int i=left; i<=right; i++){
            answer2 += ( i % Math.sqrt(i) != 0)?i:-i;
        }


        System.out.println(answer1);
        System.out.println(answer2);
    }
}

package Level2;

import java.util.Arrays;

public class boat {
    public static void main(String[] args) {

    }

        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);

            int min = 0;
            for(int max = people.length-1; max >= min; max--){
                if(people[max] + people[min] <= limit) min++;
                answer++;
            }

            return answer;
        }
}

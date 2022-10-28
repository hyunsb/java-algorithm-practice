package Level1;
import java.util.*;
public class Poketmon {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        solution(nums);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int n = nums.length/2;

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++) {
            hashSet.add(nums[i]);
        }
        if(n < hashSet.size()) answer = n;
        else answer = hashSet.size();
        return answer;
    }
}

package wooSecondWeek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class baseball {
    final static int MIN_RANGE_NUM = 1;
    final static int MAX_RANGE_NUM = 9;
    final static int MAX_ARRAY_SIZE = 3;

    public static void main(String[] args) {

    }

    // TODO : 컴퓨터가 1에서 9까지의 서로다른 임의의 수 3개를 선택하여 저장한다.
    public List<Integer> SelectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < MAX_ARRAY_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}

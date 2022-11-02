package wooSecondWeek;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        // TODO: 프로그램 구현
        List<Integer> computer = baseball.SelectRandomNumbers();

        System.out.println(computer);
    }

    // TODO : 컴퓨터가 숫자를 선택하는 메소드
    public List<Integer> SelectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

}

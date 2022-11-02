package wooSecondWeek;

import java.util.ArrayList;
import java.util.List;

public class baseball {
    public static void main(String[] args) {
        baseball baseball = new baseball();
        // TODO: 프로그램 구현
        List<Integer> computer = baseball.computerSelectNumbers();
        System.out.println(computer);
    }

    // TODO : 컴퓨터가 숫자를 선택하는 메소드
    public List<Integer> computerSelectNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)){
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

}

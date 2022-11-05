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

    // TODO : 사용자에게 3자리 수를 입력 받는다.
    public List<Integer> selectNumbers() {
        String inputNumber = Console.readLine();

    }

    // TODO : 입력 값이 3자리가 아닌 경우 예외를 발생한다.
    public boolean isLengthThree(String input) throws IllegalArgumentException{
        if(input.length() != 3)
            throw new IllegalArgumentException();
        return true;
    }

    // TODO : 입력 값의 범위가 1-9가 아닌 경우 예외를 발생한다.
    public boolean isCorrectRange(String input) throws IllegalArgumentException{
        if(input.replaceAll("[1-9]", "").isEmpty())
            throw new IllegalArgumentException();
        return true;
    }

    // TODO : 입력 값 중 중복된 숫자가 존재하는 경우 예외를 발생한다.
    public boolean isEachOtherDifferent(String input) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();
        for (char x : input.toCharArray())
            set.add(x);

        if (set.size() != MAX_ARRAY_SIZE)
            throw new IllegalArgumentException();

        return true;
    }
}

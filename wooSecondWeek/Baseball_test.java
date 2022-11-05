package wooSecondWeek;

import java.util.ArrayList;
import java.util.List;

public class Baseball_test {
    final static int MIN_RANGE_NUM = 1;
    final static int MAX_RANGE_NUM = 9;
    final static int MAX_ARRAY_SIZE = 3;


    public static void main(String[] args) {
        Baseball_test baseball = new Baseball_test();
        // TODO: 프로그램 구현

        boolean newGame = true;
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            if (newGame)
                computer = baseball.selectRandomNumbers();

            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = baseball.selectNumbers();

            // TODO : 컴퓨터, 유저 숫자를 비교해서 리스트에 담아 리턴 (볼, 스트라이크, 낫싱)
            //compareNumbers(computer, user);

            System.out.println(computer);
            System.out.println(user);
            break;
        }
    }

    // TODO : 컴퓨터가 숫자를 랜덤으로 선택하여 리턴
    public List<Integer> selectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < MAX_ARRAY_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    // TODO : 사용자가 숫자를 선택한 숫자를 리턴
    public List<Integer> selectNumbers(){
        String inputNumber = Console.readLine();

        isInputMatch(inputNumber);

        // TODO : 사용자가 선택한 숫자를 List에 담아 리턴
        List<Integer> numbers = new ArrayList<>();
        for (char number : inputNumber.toCharArray())
            numbers.add(Character.getNumericValue(number));

        return numbers;
    }

    // TODO : 사용자가 잘못된 값을 입력할 시 IllegalArgumentException 발생하는 함수
    // 입력 값의 길이가 3이 아닐 시, 0이 포함되어 있을 시, 숫자 이외의 값이 포함되어 있을 시 예외처리
    public void isInputMatch(String inputNumber) throws IllegalArgumentException{
        if (inputNumber.length() != MAX_ARRAY_SIZE
                || !inputNumber.replaceAll("[1-9]", "").isEmpty())
            throw new IllegalArgumentException();
    }

    //TODO : 컴퓨터와 사용자의 수를 비교하여 힌트를 리턴
    public String compareNumbers(List<Integer> computer, List<Integer> user){
        String answer = "";

        return answer;
    }

}

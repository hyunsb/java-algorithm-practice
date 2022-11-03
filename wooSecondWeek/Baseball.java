package wooSecondWeek;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        // TODO: 프로그램 구현

        boolean newGame = true; // 새로운 게임을 판별하는 변수
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            if (newGame)
                computer = baseball.selectRandomNumbers();

            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = baseball.selectNumbers();


            System.out.println(computer);
            System.out.println(user);
            break;
        }
    }

    // TODO : 컴퓨터가 숫자를 랜덤으로 선택하여 리턴
    public List<Integer> selectRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    // TODO : 사용자가 숫자를 선택한 숫자를 리턴
    public List<Integer> selectNumbers(){
        String inputNumber = Console.readLine();

        // TODO : 사용자가 잘못된 값을 입력할 시 IllegalArgumentException 발생
        isInputMatch(inputNumber);

        // TODO : 사용자가 선택한 숫자를 List에 담아 리턴
        List<Integer> numbers = new ArrayList<>();
        for (char number : inputNumber.toCharArray())
            numbers.add(Character.getNumericValue(number));

        return numbers;
    }

    // TODO : 사용자가 잘못된 값을 입력할 시 IllegalArgumentException 발생하는 함수
    public void isInputMatch(String inputNumber){
        // 입력 값의 길이가 3이 아닐 시, 0이 포함되어 있을 시, 숫자 이외의 값이 포함되어 있을 시 예외처리
        if (inputNumber.length() != 3
                || inputNumber.contains("0")
                || !inputNumber.replaceAll("[1-9]", "").isEmpty())
            throw new IllegalArgumentException();
    }

    //TODO : 컴퓨터와 사용자의 수를 비교하여 힌트를 리턴
    public String compareNumbers(){
        String answer = "";
        return answer;
    }

}

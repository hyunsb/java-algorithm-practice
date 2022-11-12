package WooThirdWeek;

import java.lang.reflect.Array;
import java.util.*;

public class Error {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MAX_VALUE_OF_WINNING_NUMBER = 45;
    private static final int MIN_VALUE_OF_WINNING_NUMBER = 1;

    // TODO : 로또 구매 금액을 입력 받아 검증 후 반환한다.
    public static int isCorrectAmount(String purchaseAmount) {
        int amount = isContainCharacter(purchaseAmount);
        isDividedByTicketPrice(amount);
        return amount;
    }

    // TODO : 입력 값이 1,000으로 나누어 떨어지지 않는 경우 예외 처리 한다.
    private static void isDividedByTicketPrice(int purchaseAmount) throws IllegalArgumentException{
        if (purchaseAmount % TICKET_PRICE != ZERO)
            throw new IllegalArgumentException("[ERROR] The unit of the purchase amount is not 1,000.");
    }

    // TODO : 입력 값에 문자가 포함되어 있는 경우 예외 처리 한다.
    private static int isContainCharacter(String purchaseAmount) throws IllegalArgumentException{
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] Characters exist in the input value.");
        }
    }

    // TODO: 담청 번호 6자리를 입력받아 검증 후 반환한다.
    public List<String> isCorrectWinningNumbers(String winningNumber){
        List<String> winningNumbers = isSixInputValues(splitBasedComma(winningNumber));
        if (isAllDifferentValues(winningNumbers) && isRangeFromOneToFortyFive(winningNumbers))
            return winningNumbers;
        throw new IllegalArgumentException();
    }

    // TODO: 입력 값의 문자 혹은 숫자가 6개가 아닌 경우 예외 처리한다.
    private static List<String> isSixInputValues(List<String> winningNumbers) throws IllegalArgumentException{
        if (winningNumbers.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] The number of input values does not match 6.");
        return winningNumbers;
    }

    // TODO: 입력 값에 중복된 숫자가 존재하는 경우 예외 처리한다.
    private static boolean isAllDifferentValues(List<String> winningNumbers) throws IllegalArgumentException{
        Set<String> WinningSet = new HashSet<>(winningNumbers);
        if (WinningSet.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] Duplicate number exists in input value.");
        return true;
    }

    // TODO: 입력 값이= 1~45 범위에 해당하는 경우 True 를 반환한다.
    private static boolean isRangeFromOneToFortyFive(List<String> winningNumbers) throws IllegalArgumentException{
        for(String number : winningNumbers) {
            isMatchFromOneToFortyFive(number);
        }
        return true;
    }

    // 리팩토링 필요
    // TODO: 문자열을 1~45와 비교하여 일치하지 않는 경우 예외 처리한다.
    private static void isMatchFromOneToFortyFive(String number) throws IllegalArgumentException{
        try {
            if (!(MIN_VALUE_OF_WINNING_NUMBER <= Integer.parseInt(number)
                    && Integer.parseInt(number) <= MAX_VALUE_OF_WINNING_NUMBER))
                throw new IllegalArgumentException("[ERROR] An out-of-range number or character exists in the input value.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] An out-of-range number or character exists in the input value.");
        }

    }

    // TODO: 입력 값을 쉼표 기준으로 분리하여 리스트로 반환한다.
    private static List<String> splitBasedComma(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

}

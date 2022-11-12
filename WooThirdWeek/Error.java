package WooThirdWeek;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Error {
    private static final int ZERO = 0;
    private static final int TICKET_PRICE = 1000;
    private static final int WINNING_NUMBER_SIZE = 6;


    private Error() {
    }

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

    // TODO: 입력 값의 문자 혹은 숫자가 6개가 아닌 경우 예외 처리한다.
    private static List<String> isSixInputValues(List<String> winningNumbers) throws IllegalArgumentException{
        if (winningNumbers.size() != WINNING_NUMBER_SIZE)
            throw new IllegalArgumentException("[ERROR] The number of input values does not match 6.");
        return winningNumbers;
    }

    // TODO: 입력 값에 중복된 숫자가 존재하는 경우 예외 처리한다.


    // TODO: 입력 값에 1~45 범위에 해당하지 않는 숫자나 문자가 존재하는 경우 경우 예외 처리한다.


    // TODO: 입력 값을 쉼표 기준으로 분리하여 리스트로 반환한다.
    private static List<String> splitBasedComma(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(","));
    }

}

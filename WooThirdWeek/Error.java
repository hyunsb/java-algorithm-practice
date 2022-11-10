package WooThirdWeek;

public class Error {
    final private static int TICKET_PRICE = 1000;

    // TODO : 입력 값이 1,000으로 나누어 떨어지지 않는 경우 예외 처리 한다.
    public boolean isDividedByTicketPrice(int purchaseAmount) throws IllegalArgumentException{
        if (purchaseAmount % TICKET_PRICE > 0)
            throw new IllegalArgumentException("[ERROR] The unit of the purchase amount is not 1,000");
        return true;
    }

}

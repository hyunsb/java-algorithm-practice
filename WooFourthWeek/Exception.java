package WooFourthWeek;

public class Exception {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static int convertStringToInteger(String inputValue) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_PREFIX);
        }
    }

    public static int validateRangeThreeToTwenty(int bridgeSize) throws IllegalArgumentException{
        if( 3 <= bridgeSize && bridgeSize <= 20)
            return bridgeSize;
        throw new IllegalArgumentException(ERROR_PREFIX);
    }
}

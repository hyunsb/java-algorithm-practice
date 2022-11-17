package WooFourthWeek;

public class Exception {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CONTAIN_CHARACTER = "Characters exist in the input value.";
    private static final String OUT_RANGE_OF_BRIDGE_SIZE = "An out-of-range number exists in the input value.";

    public static int convertStringToInteger(String inputValue) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_PREFIX + CONTAIN_CHARACTER);
        }
    }

    public static int validateRangeThreeToTwenty(int bridgeSize) throws IllegalArgumentException{
        if( 3 <= bridgeSize && bridgeSize <= 20)
            return bridgeSize;
        throw new IllegalArgumentException(ERROR_PREFIX + OUT_RANGE_OF_BRIDGE_SIZE);
    }
}

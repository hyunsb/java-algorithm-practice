package WooFourthWeek;

public class Exception {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String CONTAIN_CHARACTER = "Characters exist in the input value.";
    private static final String OUT_RANGE_OF_BRIDGE_SIZE = "An out-of-range number exists in the input value.";
    private static final String INVALID_INPUT_VALUE_FOR_MOVE = "Invalid input value to move.";

    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final String USER_MOVE_UP = "U";
    private static final String USER_MOVE_DOWN = "D";

    public static int convertStringToInteger(String inputValue) throws IllegalArgumentException{
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_PREFIX + CONTAIN_CHARACTER);
        }
    }

    public static int validateRangeThreeToTwenty(int bridgeSize) throws IllegalArgumentException{
        if ( MIN_BRIDGE_SIZE <= bridgeSize && bridgeSize <= MAX_BRIDGE_SIZE)
            return bridgeSize;
        throw new IllegalArgumentException(ERROR_PREFIX + OUT_RANGE_OF_BRIDGE_SIZE);
    }

    public static String validateInputValueForMove(String moving){
        if (moving.equals(USER_MOVE_UP) || (moving.equals(USER_MOVE_DOWN)))
            return moving;
        throw new IllegalArgumentException(ERROR_PREFIX + INVALID_INPUT_VALUE_FOR_MOVE);
    }
}

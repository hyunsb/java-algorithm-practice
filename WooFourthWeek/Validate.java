package WooFourthWeek;

public class Validate {

    public static int bridgeSize(String bridgeSize){
        return Exception.validateRangeThreeToTwenty
                (Exception.convertStringToInteger(bridgeSize));
    }
}

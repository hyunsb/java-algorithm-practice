package WooFourthWeek;

public class Controller {

    public void createBridge(){
        OutputView.printStartMessage();
        OutputView.printInputLengthOfBridge();
        System.out.println(InputView.readBridgeSize());
    }
}

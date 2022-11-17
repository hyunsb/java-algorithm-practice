package WooFourthWeek;

public class Controller {
    private final BridgeGame bridgeGame = new BridgeGame();

    public Controller(){
        try {
            bridgeGameStart();
            bridgeSet();
        } catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }

    public void bridgeGameStart() {
        OutputView.printStartMessage();
    }

    public void bridgeSet(){
        OutputView.printInputLengthOfBridge();
        bridgeGame.createBridge();
    }
}

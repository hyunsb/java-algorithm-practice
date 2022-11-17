package WooFourthWeekTest.WooFourthWeek;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    MapMaker mapMaker;
    private int count = 0;
    private boolean gameResult = true;

    public Controller(){
        try {
            OutputView.printStartMessage();
            createBridge();
            print();
            movingBridge();
            System.out.println("최종 게임 결과" + !gameResult);
            OutputView.printMap(mapMaker);
            OutputView.printResult(count);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    // TODO: 다리를 생성한다.
    public void createBridge(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.printInputLengthOfBridge();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }


    //TODO: 다리를 이동하며 게임을 진행한다.
    public void movingBridge(){
        while (true){
            count ++;
            bridgeGameSet();
            if(!bridgeMoveRoutine()) break;
        }
    }

    public boolean bridgeMoveRoutine(){
        mapMaker = new MapMaker(bridge);
        while (true){
            OutputView.printInputDirectionToMove();
            boolean correctBridge = bridgeGame.move(InputView.readMoving());
            createMap(correctBridge);

            if(!correctBridge)
                return isRetry();

            if(bridgeGame.isEndBridge())
                return (gameResult = false);
        }
    }

    private void createMap(boolean correctBridge){
        mapMaker.createMap(correctBridge);
        OutputView.printMap(mapMaker);
    }

    private void bridgeGameSet(){
        bridgeGame = new BridgeGame(bridge);
    }

    private boolean isRetry(){
        OutputView.printInputGameRestartStatus();
        return bridgeGame.retry(InputView.readGameCommand());
    }

    public void print(){
        System.out.println(bridge);
    }
}

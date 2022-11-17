package WooFourthWeekTest.WooFourthWeek;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    private int count = 0;

    public Controller(){
        try {
            OutputView.printStartMessage();
            createBridge();
            print();
            movingBridge();
        } catch (IllegalArgumentException exception){
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
            if(!bridgeMoveRoutine()){
                OutputView.printResult(count);
            }
        }
    }

    public boolean bridgeMoveRoutine(){
        MapMaker mapMaker = new MapMaker(bridge);
        boolean retry;
        while (true){
            boolean correctBridge = bridgeGame.move(InputView.readMoving());
            mapMaker.createMap(correctBridge);
            OutputView.printMap(mapMaker);
            if(!correctBridge){
                retry = isRetry();
                break;
            }
        }
        return retry;
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

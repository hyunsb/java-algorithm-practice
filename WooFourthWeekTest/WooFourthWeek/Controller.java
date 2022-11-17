package WooFourthWeekTest.WooFourthWeek;

import WooFourthWeek.MapMaker;

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
        bridgeGameSet();
        while (true){
            bridgeMoveRoutine();
        }
    }

    public void bridgeMoveRoutine(){
        MapMaker mapMaker = new MapMaker();
        bridgeGame.move(InputView.readMoving());
    }

    public void bridgeGameSet(){
        bridgeGame = new BridgeGame(bridge);
    }



    public void print(){
        System.out.println(bridge);
    }
}

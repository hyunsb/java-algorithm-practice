package WooFourthWeek;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {
    private List<String> bridge = new ArrayList<>();

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
        BridgeGame bridgeGame = new BridgeGame(bridge);
        OutputView.printEnter();
        movingRoutine(bridgeGame);
    }

    private void movingRoutine(BridgeGame bridgeGame){
        MapMaker mapMaker = new MapMaker();
        int order = 0;
        while ( order < bridge.size() ){
            OutputView.printInputDirectionToMove();
            String move = InputView.readMoving();
            boolean correctBridge = bridgeGame.move(order, move);

            mapMaker.createMap(move, correctBridge);
            OutputView.printMap(mapMaker);

            if (!correctBridge){
                OutputView.printInputGameRestartStatus();
                mapMaker = bridgeGame.retry(mapMaker, InputView.readGameCommand());

                if(!mapMaker.EmptyMap()){
                    OutputView.printMap(mapMaker);
                    break;
                }
                order = 0;
                continue;
            }
            order += 1;
            OutputView.printEnter();
        }
    }

    private MapMaker gameReStart(){
        return new MapMaker();
    }


    public void print(){
        System.out.println(bridge);
    }
}

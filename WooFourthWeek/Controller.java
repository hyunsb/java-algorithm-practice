package WooFourthWeek;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();

    public Controller(){
        try {
            OutputView.printStartMessage();
            createBridge();
            print();
            // 재시작 하면 여기서부터 시작
            movingBridge();
            // 종료되면 결과 출력
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

    //TODO: 이동하며 비교
    public void movingBridge(){
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MapMaker mapMaker = new MapMaker();
        OutputView.printEnter();

        int order = 0;
        while ( order < bridge.size() ){
            OutputView.printInputDirectionToMove();
            String move = InputView.readMoving();
            System.out.println(order + " " + move);
            boolean correctBridge = bridgeGame.move(order, move);

            mapMaker.createMap(move, correctBridge);
            mapMaker.printMap();
            if (!correctBridge){
                break;
            }

            OutputView.printEnter();
            order += 1;
        }
    }


    public void print(){
        System.out.println(bridge);
    }
}

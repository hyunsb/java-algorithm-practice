package WooFourthWeek;

import javax.swing.plaf.LabelUI;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return initializeBridge(size);
    }

    //TODO: 다리의 길이 만큼 반복
    private List<String> initializeBridge(int size){
        List<String> bridge = new ArrayList<>();
        while (bridge.size() < size){
            bridge.add(convertCorrectBridge());
        }
        return bridge;
    }

    //TODO: U D로 변환
    private String convertCorrectBridge(){
        if (bridgeNumberGenerator.generate() == 0)
            return "U";
        return "D";
    }
}

package WooFourthWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean move(int order, String moving) {
        return bridge.get(order).equals(moving);
    }

    public void retry() {
    }



}

package WooFourthWeekTest.WooFourthWeek;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String COMMAND_RESTART = "R";
    private static final String COMMAND_QUIT = "Q";

    private List<String> bridge;
    private int count = 0;

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean move(String move) {
        boolean moveResult = bridge.get(count).equals(move);
        count++;
        return moveResult;
    }

    public boolean isEndBridge(){
        return (count == bridge.size()-1);
    }


}

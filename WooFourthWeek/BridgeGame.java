package WooFourthWeek;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Queue<String> bridge;
    private static final String COMMAND_RESTART = "R";
    private static final String COMMAND_QUIT = "Q";

    BridgeGame(List<String> bridge){
        this.bridge = new LinkedList<>(bridge);
    }

    public boolean move(int order, String moving) {
        return bridge.remove().equals(moving);
    }

    public MapMaker retry(MapMaker mapMaker, String gameCommand) {
        if (gameCommand.equals(COMMAND_RESTART))
            return new MapMaker();
        if (gameCommand.equals(COMMAND_QUIT))
            return mapMaker;
        throw new IllegalArgumentException();
    }


    public boolean isBridgeEnd() {
        return bridge.isEmpty();
    }
}

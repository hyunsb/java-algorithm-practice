package WooFourthWeek;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private static final String COMMAND_RESTART = "R";
    private static final String COMMAND_QUIT = "Q";

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean move(int order, String moving) {
        return bridge.get(order).equals(moving);
    }

    public MapMaker retry(MapMaker mapMaker, String gameCommand) {
        if (gameCommand.equals(COMMAND_RESTART))
            return new MapMaker();
        return mapMaker;
    }



}

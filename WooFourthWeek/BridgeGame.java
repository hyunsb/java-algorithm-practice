package WooFourthWeek;

import java.util.List;

public class BridgeGame {
    private static final String COMMAND_RESTART = "R";
    private static final String COMMAND_QUIT = "Q";

    private List<String> bridge;
    private int count;

    BridgeGame(List<String> bridge){
        this.bridge = bridge;
        count = 0;
    }

    public boolean move(String move) {
        return correctBridge().equals(move);
    }

    public boolean retry(String gameCommand){
        if(gameCommand.equals(COMMAND_RESTART))
            return true;
        if(gameCommand.equals(COMMAND_QUIT))
            return false;
        throw new IllegalArgumentException();
    }

    private String correctBridge(){
        return bridge.get(count++);
    }

    public boolean isEndBridge(){
        return (count == bridge.size());
    }
}

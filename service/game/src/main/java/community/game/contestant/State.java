package community.game.contestant;

import community.game.match.Position;

public class State {
    private final Position position;
    private final int remainingDelay;

    public State(Position position, int remainingDelay) {
        this.position = position;
        this.remainingDelay = remainingDelay;
    }

    public Position getPosition() {
        return position;
    }

    public int getRemainingDelay() {
        return remainingDelay;
    }
}

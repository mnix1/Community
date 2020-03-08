package community.game.match.state;

import community.game.Id;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;

public class ContestantState {
    private final Id id = Id.random();
    private final Player player;
    private final Wisie wisie;
    private Position position;
    private int delay;
    private int health;

    public ContestantState(Player player, Wisie wisie, Position startPosition) {
        this.player = player;
        this.wisie = wisie;
        this.delay = wisie.getBaseStats().getDelay();
        this.health = wisie.getBaseStats().getStartHealth();
        //TODO validate start position and cost
        this.position = startPosition;
    }

    public Id getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Wisie getWisie() {
        return wisie;
    }

    public ContestantState position(Position position) {
        this.position = position;
        return this;
    }

    public ContestantState delay(int delay) {
        this.delay = delay;
        return this;
    }

    public ContestantState health(int health) {
        this.health = health;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public int getDelay() {
        return delay;
    }

    public int getHealth() {
        return health;
    }
}

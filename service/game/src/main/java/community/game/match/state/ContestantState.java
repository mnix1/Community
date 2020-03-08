package community.game.match.state;

import community.game.Id;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;

public class ContestantState {
    private final Id id = Id.random();
    private final Player player;
    private final Wisie wisie;
    private Position position;
    private int energy;
    private int health;

    public ContestantState(Player player, Wisie wisie, Position startPosition) {
        this.player = player;
        this.wisie = wisie;
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

    public ContestantState energy(int energy) {
        this.energy = energy;
        return this;
    }

    public ContestantState health(int health) {
        this.health = health;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }
}

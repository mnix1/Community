package community.game.match.state;

import community.game.match.metadata.contestant.Contestant;

public class ContestantState {
    private final Contestant contestant;
    private Position position;
    private int delay;
    private int health;

    public ContestantState(Contestant contestant) {
        this.contestant = contestant;
        this.delay = contestant.getWisie().getBaseStats().getDelay();
        this.health = contestant.getWisie().getBaseStats().getStartHealth();
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

    public Contestant getContestant() {
        return contestant;
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

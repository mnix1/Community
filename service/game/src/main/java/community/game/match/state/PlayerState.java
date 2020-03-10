package community.game.match.state;

import community.game.match.metadata.Player;

public class PlayerState {
    private final Player player;
    private int energy;
    private int health;

    public PlayerState(Player player) {
        this.player = player;
    }

    public PlayerState energy(int energy) {
        this.energy = energy;
        return this;
    }

    public PlayerState health(int health) {
        this.health = health;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHealth() {
        return health;
    }
}

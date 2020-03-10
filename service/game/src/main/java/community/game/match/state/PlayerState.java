package community.game.match.state;

import community.game.match.metadata.Player;

public class PlayerState {
    private final Player player;
    private int energy;

    public PlayerState(Player player) {
        this.player = player;
        this.energy = player.getEnergyMax();
    }

    public PlayerState energy(int energy) {
        this.energy = energy;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public int getEnergy() {
        return energy;
    }
}

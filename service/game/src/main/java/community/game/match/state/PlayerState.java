package community.game.match.state;

import community.game.Id;
import community.game.match.metadata.Player;

public class PlayerState {
    private final Id id;
    private int energy;

    public PlayerState(Player player) {
        this.id = player.getId();
        this.energy = player.getMaxEnergy();
    }
}

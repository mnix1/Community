package community.game.match.state.changer;

import community.game.Id;
import community.game.match.Match;
import community.game.match.state.PlayerState;

public class ChangePlayerEnergy implements StateChanger {
    private final Id playerId;
    private final int energyChange;

    public ChangePlayerEnergy(Id playerId, int energyChange) {
        this.playerId = playerId;
        this.energyChange = energyChange;
    }

    @Override
    public void apply(Match match) {
        PlayerState player = match.getState().getPlayer(playerId);
        player.energy(player.getEnergy() + energyChange);
    }
}

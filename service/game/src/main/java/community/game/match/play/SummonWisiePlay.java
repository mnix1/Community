package community.game.match.play;

import community.game.Id;
import community.game.match.Match;
import community.game.match.state.changer.StateChanger;

import java.time.Instant;
import java.util.List;

public class SummonWisiePlay extends Play {
    private final Id wisieId;

    public SummonWisiePlay(Id playerId, Id wisieId, Instant created) {
        super(playerId, created, PlayType.SUMMON_WISIE);
        this.wisieId = wisieId;
    }

    @Override
    public boolean canPlay(Match match) {
        return match.getState().getPlayer(playerId).getEnergy() >= match.getMetadata().getPlayers().get(playerId).getWisie(wisieId).getSummonEnergyCost();
    }

    @Override
    public List<StateChanger> toStateChangers(Match match) {
        return null;
    }
}

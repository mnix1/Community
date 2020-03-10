package community.game.match.play;

import community.game.Id;
import community.game.match.Args;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.MatchState;
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
    public boolean canPlay(MatchState state, MatchMetadata metadata) {
        return state.getPlayer(playerId).getEnergy() >= metadata.getPlayers().get(playerId).getWisie(wisieId).getBaseStats().get(WisieStat.SUMMON_COST).get(new Args());
    }

    @Override
    public List<StateChanger> toStateChangers(MatchState state, MatchMetadata metadata) {
        return null;
    }
}

package community.game.match.play;

import community.game.Id;
import community.game.match.Match;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import community.game.match.state.PlayerState;
import community.game.match.state.changer.ChangePlayerEnergy;
import community.game.match.state.changer.StateChanger;
import community.game.match.state.changer.AddContestant;

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
        return playerState(match).getEnergy() >= wisieEnergyCost(match);
    }

    @Override
    public List<StateChanger> toStateChangers(Match match) {
        Player player = playerState(match).getPlayer();
        ContestantState contestantState = new ContestantState(player, player.getWisie(wisieId), match.getMetadata().getBoard().startPosition(player.isMain()));
        return List.of(
                new ChangePlayerEnergy(playerId, -wisieEnergyCost(match)),
                new AddContestant(contestantState)
        );
    }

    private PlayerState playerState(Match match) {
        return match.getState().getPlayer(playerId);
    }

    private int wisieEnergyCost(Match match) {
        return wisie(match).getStats().get(WisieStat.SUMMON_ENERGY_COST).get(null, match);
    }

    private Wisie wisie(Match match) {
        return match.getMetadata().getPlayers().get(playerId).getWisie(wisieId);
    }
}

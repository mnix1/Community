package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.Match;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.attack.DefaultAttackInteraction;
import community.game.match.metadata.wisie.interaction.move.DefaultMoveInteraction;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DefaultInteractionController implements InteractionController {

    @Override
    public List<Interaction> interactions(ContestantState source, Match match) {
        List<Interaction> moveInteractions = List.of(new DefaultMoveInteraction());
        if (source.getEnergy() >= source.getWisie().getStats().get(WisieStat.ATTACK_ENERGY_COST).get(source, match)) {
            return findOpponentToAttack(source, match).
                    <List<Interaction>>map(c -> List.of(new DefaultAttackInteraction(c)))
                    .orElse(moveInteractions);
        } else if (source.getEnergy() >= source.getWisie().getStats().get(WisieStat.MOVE_ENERGY_COST).get(source, match)) {
            return moveInteractions;
        }
        return List.of();
    }

    private Optional<ContestantState> findOpponentToAttack(ContestantState source, Match match) {
        return match.getState().allContestants().stream()
                .filter(c -> !c.getPlayer().getId().equals(source.getPlayer().getId()))
                .map(c -> Tuples.of(c, source.getPosition().distance(c.getPosition())))
                .filter(t -> t.getT2() <= source.getWisie().getStats().get(WisieStat.ATTACK_RANGE).get(source, match))
                .min(Comparator.comparing(Tuple2::getT2))
                .map(Tuple2::getT1);
    }

}

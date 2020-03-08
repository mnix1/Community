package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.attack.DefaultAttackInteraction;
import community.game.match.metadata.wisie.interaction.move.DefaultMoveInteraction;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DefaultInteractionController implements InteractionController {

    @Override
    public List<Interaction> interactions(ContestantState source, MatchState state, MatchMetadata metadata) {
        return findOpponentToAttack(source, state).
                <List<Interaction>>map(c -> List.of(new DefaultAttackInteraction()))
                .orElseGet(() -> List.of(new DefaultMoveInteraction()));
    }

    private Optional<ContestantState> findOpponentToAttack(ContestantState source, MatchState state) {
        return state.getContestantStates().stream()
                .filter(c -> !c.getPlayer().getId().equals(source.getPlayer().getId()))
                .map(c -> Tuples.of(c, source.getPosition().distance(c.getPosition())))
                .filter(t -> t.getT2() <= source.getWisie().getBaseStats().getAttackRange())
                .min(Comparator.comparing(Tuple2::getT2))
                .map(Tuple2::getT1);
    }

}

package community.game.wisie.interaction.controller;

import community.game.contestant.Contestant;
import community.game.contestant.Contestants;
import community.game.wisie.interaction.Interaction;
import community.game.wisie.interaction.attack.DefaultAttackInteraction;
import community.game.wisie.interaction.move.DefaultMoveInteraction;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DefaultInteractionController implements InteractionController {
    @Override
    public List<Interaction> interactions(Contestant source, Contestants contestants) {
        return findOpponentToAttack(source, contestants).
                <List<Interaction>>map(contestant -> List.of(new DefaultAttackInteraction(source, contestant)))
                .orElseGet(() -> List.of(new DefaultMoveInteraction(source)));
    }

    private Optional<Contestant> findOpponentToAttack(Contestant source, Contestants contestants) {
        return contestants.get(source.getTeamId()).getAll().stream()
                .map(c -> Tuples.of(c, source.getState().getPosition().distance(c.getState().getPosition())))
                .filter(t -> t.getT2() <= source.getWisie().getBaseStats().getAttackRange())
                .min(Comparator.comparing(Tuple2::getT2))
                .map(Tuple2::getT1);
    }
}

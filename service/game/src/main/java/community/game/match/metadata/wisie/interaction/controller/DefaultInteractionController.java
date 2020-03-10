package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.Args;
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
    public List<Interaction> interactions(Args args) {
        List<Interaction> moveInteractions = List.of(new DefaultMoveInteraction());
        if (args.getSource().getEnergy() >= args.getSource().getWisie().getBaseStats().get(WisieStat.ATTACK_ENERGY_COST).get(args)) {
            return findOpponentToAttack(args).
                    <List<Interaction>>map(c -> List.of(new DefaultAttackInteraction(c)))
                    .orElse(moveInteractions);
        } else if (args.getSource().getEnergy() >= args.getSource().getWisie().getBaseStats().get(WisieStat.MOVE_ENERGY_COST).get(args)) {
            return moveInteractions;
        }
        return List.of();
    }

    private Optional<ContestantState> findOpponentToAttack(Args args) {
        return args.getState().allContestants().stream()
                .filter(c -> !c.getPlayer().getId().equals(args.getSource().getPlayer().getId()))
                .map(c -> Tuples.of(c, args.getSource().getPosition().distance(c.getPosition())))
                .filter(t -> t.getT2() <= args.getSource().getWisie().getBaseStats().get(WisieStat.ATTACK_RANGE).get(args))
                .min(Comparator.comparing(Tuple2::getT2))
                .map(Tuple2::getT1);
    }

}

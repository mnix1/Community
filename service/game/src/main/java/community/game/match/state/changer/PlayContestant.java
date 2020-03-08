package community.game.match.state.changer;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

public class PlayContestant implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.getContestantStates().stream().filter(c -> c.getDelay() <= 0)
                .forEach(c -> {
                    InteractionController interactionController = c.getWisie().getType().getInteractionController();
                    interactionController.interactions(c, state, metadata);
                });
    }

}

package community.game.match.state.changer;

import community.game.match.Args;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.InteractionProvider;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;
import community.game.match.state.MatchState;

import java.util.List;

public class AutoPlayContestant implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.allContestants()
                .forEach(c -> {
                    InteractionController controller = InteractionProvider.findController(c.getWisie().getType(), metadata.getCreated());
                    Args args = new Args(c, state, metadata);
                    List<Interaction> interactions = controller.interactions(args);
                    interactions.forEach(interaction -> interaction.invoke(args));
                });
    }

}

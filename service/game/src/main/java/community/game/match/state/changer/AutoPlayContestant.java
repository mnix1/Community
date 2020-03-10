package community.game.match.state.changer;

import community.game.match.Match;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.InteractionProvider;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

import java.util.List;

public class AutoPlayContestant implements StateChanger {
    @Override
    public void apply(Match match) {
        match.getState().allContestants()
                .forEach(c -> {
                    InteractionController controller = InteractionProvider.findController(c.getWisie().getType(), match.getMetadata().getCreated());
                    List<Interaction> interactions = controller.interactions(c, match);
                    interactions.forEach(interaction -> interaction.invoke(c, match));
                });
    }

}

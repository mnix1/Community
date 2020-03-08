package community.game.match.state.changer;

import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.state.MatchState;

import java.util.List;

public class PlayContestant implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.getContestantStates().stream().filter(c -> c.getDelay() < 0)
                .forEach(c -> {
                    List<Interaction> interactions = c.getWisie().getType().getInteractionController().interactions(c, state, metadata);
                    interactions.forEach(interaction -> interaction.invoke(c, state, metadata));
                    c.delay(c.getWisie().getBaseStats().getDelay());
                });
    }

}

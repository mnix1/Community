package community.game.match.metadata.wisie.interaction;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;

public interface Interaction {
    InteractionType type();

    void invoke(ContestantState source, MatchState state, MatchMetadata metadata);
}

package community.game.match.metadata.wisie.interaction;

import community.game.match.Match;
import community.game.match.state.ContestantState;

public interface Interaction {
    InteractionType type();

    void invoke(ContestantState source, Match match);
}

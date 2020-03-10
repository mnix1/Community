package community.game.match.metadata.wisie.stat;

import community.game.match.Match;
import community.game.match.state.ContestantState;

public interface StatValueProvider {
    StatValueProviderType getType();

    int get(ContestantState source, Match match);
}

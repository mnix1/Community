package community.game.match.metadata.wisie.stat;

import community.game.match.Args;
import community.game.match.metadata.MatchMetadata;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;

public interface StatValueProvider {
    default int get(Args args) {
        return get();
    }

    int get();
}

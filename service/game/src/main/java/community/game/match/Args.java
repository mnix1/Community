package community.game.match;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;

public class Args {
    private final ContestantState source;
    private final MatchState state;
    private final MatchMetadata metadata;

    public Args(ContestantState source, MatchState state, MatchMetadata metadata) {
        this.source = source;
        this.state = state;
        this.metadata = metadata;
    }

    public ContestantState getSource() {
        return source;
    }

    public MatchState getState() {
        return state;
    }

    public MatchMetadata getMetadata() {
        return metadata;
    }
}

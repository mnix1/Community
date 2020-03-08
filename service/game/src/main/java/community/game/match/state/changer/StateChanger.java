package community.game.match.state.changer;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;

public interface StateChanger {
    void apply(MatchState state, MatchMetadata metadata);

}

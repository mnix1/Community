package community.game.match.metadata;

import community.game.match.Match;
import community.game.match.metadata.wisie.stat.WisieStatValueProviderType;
import community.game.match.state.ContestantState;
import community.game.match.state.PlayerState;

public interface PlayerStatValueProvider {
    PlayerStatValueProviderType getType();

    int get(PlayerState source, Match match);
}

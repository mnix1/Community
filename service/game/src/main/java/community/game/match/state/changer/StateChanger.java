package community.game.match.state.changer;

import community.game.match.Match;

public interface StateChanger {
    void apply(Match match);
}

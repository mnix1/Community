package community.game.match;

import community.game.Id;

public interface MatchCreator {
    Match create(Id main, Id opponent);
}

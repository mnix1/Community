package community.game.match;

import java.util.List;

public interface Speed {
    int speed(Id sourceId, List<Contestant> contestants);
}

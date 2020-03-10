package community.game.match.metadata.wisie.stat;

import community.game.match.Match;
import community.game.match.state.ContestantState;

import static community.game.match.metadata.wisie.stat.StatValueProviderType.CONST_VALUE;

public class ConstStatValueProvider implements StatValueProvider {
    private final int value;

    public ConstStatValueProvider(int value) {
        this.value = value;
    }

    @Override
    public StatValueProviderType getType() {
        return CONST_VALUE;
    }

    @Override
    public int get(ContestantState source, Match match) {
        return value;
    }

}

package community.game.match.metadata.wisie.stat;

import community.game.match.Match;
import community.game.match.state.ContestantState;

import static community.game.match.metadata.wisie.stat.WisieStatValueProviderType.CONST_VALUE;

public class ConstWisieStatValueProvider implements WisieStatValueProvider {
    private final int value;

    public ConstWisieStatValueProvider(int value) {
        this.value = value;
    }

    @Override
    public WisieStatValueProviderType getType() {
        return CONST_VALUE;
    }

    @Override
    public int get(ContestantState source, Match match) {
        return value;
    }

}

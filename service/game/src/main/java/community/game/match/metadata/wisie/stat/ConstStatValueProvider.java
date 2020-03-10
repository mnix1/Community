package community.game.match.metadata.wisie.stat;

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
    public int get() {
        return value;
    }
}

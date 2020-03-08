package community.game.match.metadata.wisie.stat;

public class ConstStatValueProvider implements StatValueProvider {
    private final int value;

    public ConstStatValueProvider(int value) {
        this.value = value;
    }

    @Override
    public int get() {
        return value;
    }
}

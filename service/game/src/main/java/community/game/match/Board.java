package community.game.match;

import community.game.match.state.Position;

public class Board {
    public final static int MIN_ROW = 0;
    public final static int MAX_ROW = 10;
    public final static int MIDDLE_ROW = (MAX_ROW - MIN_ROW) / 2;
    public final static int MIN_COLUMN = 0;
    public final static int MAX_COLUMN = 10;
    public final static int MIDDLE_COLUMN = (MIN_COLUMN - MAX_COLUMN) / 2;

    private final int minRow = MIN_ROW;
    private final int maxRow = MAX_ROW;
    private final int minColumn = MIN_COLUMN;
    private final int maxColumn = MAX_COLUMN;

    public Position startPosition(boolean main) {
        if (main) {
            return new Position(main, MIN_ROW, MIDDLE_COLUMN);
        }
        return new Position(main, MAX_ROW, MIDDLE_COLUMN);
    }

    public int getMinRow() {
        return minRow;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMinColumn() {
        return minColumn;
    }

    public int getMaxColumn() {
        return maxColumn;
    }
}

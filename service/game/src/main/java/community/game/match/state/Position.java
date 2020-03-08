package community.game.match.state;

import community.game.match.Board;

import static community.game.RandomHelper.randomInteger;
import static community.game.match.Board.*;

public class Position {
    private final boolean main;
    private final int row;
    private final int column;

    public Position(boolean main, int row, int column) {
        this.main = main;
        this.row = row;
        this.column = column;
    }

    public static Position random(boolean main) {
        int row = main ? randomInteger(MIN_ROW, MIDDLE_ROW - 1) : randomInteger(MIDDLE_ROW + 1, MAX_ROW);
        return new Position(main, row, randomInteger(Board.MIN_COLUMN, Board.MAX_COLUMN));
    }

    public Position forward(int rows) {
        return new Position(main, row + rows * factor(), column);
    }

    public double distance(Position position) {
        int dRow = row - position.row;
        int dColumn = column - position.column;
        return Math.sqrt(dRow * dRow + dColumn * dColumn);
    }

    private int factor() {
        return main ? 1 : -1;
    }
}

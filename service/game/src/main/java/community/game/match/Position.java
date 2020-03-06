package community.game.match;

public class Position {
    private final int factor;
    private final int row;
    private final int column;

    public Position(int factor, int row, int column) {
        this.factor = factor;
        this.row = row;
        this.column = column;
    }

    public Position forward(int rows) {
        return new Position(factor, row + rows * factor, column);
    }
}

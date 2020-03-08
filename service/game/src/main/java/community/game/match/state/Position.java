package community.game.match.state;

public class Position {
    private final boolean main;
    private final int row;
    private final int column;

    public Position(boolean main, int row, int column) {
        this.main = main;
        this.row = row;
        this.column = column;
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

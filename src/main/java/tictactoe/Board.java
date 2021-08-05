package tictactoe;

public class Board {

    private final Symbol[][] grid;
    private int cntMoves;

    public Board(int size) {
        if (size < 3) throw new IllegalStateException("size has to be greater or equal 3");
        this.grid = initGrid(size);
        this.cntMoves = size * size;
    }

    private Symbol[][] initGrid(int size) {
        Symbol[][] grid = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
        return grid;
    }

    public void set(int x, int y, Symbol symbol) {
        if (x < 0 || x >= grid.length)
            throw new IllegalStateException("x has to be between 0 and " + (grid.length - 1));
        if (y < 0 || y >= grid[0].length)
            throw new IllegalStateException("y has to be between 0 and " + (grid[0].length - 1));
        if (grid[x][y] != Symbol.EMPTY)
            throw new IllegalStateException("x=" + x + ", y=" + y + " has value=" + grid[x][y]);
        grid[x][y] = symbol;
        cntMoves--;
    }

    public boolean isWinnerMove(Move move) {
        boolean isHorizontal = true;
        boolean isVertical = true;
        boolean isDiagonal = true;
        boolean isOppDiagonal = true;
        for (int i = 0; i < grid.length; i++) {
            if (grid[move.getX()][i] != move.getSymbol()) isHorizontal = false;
            if (grid[i][move.getY()] != move.getSymbol()) isVertical = false;
            if (grid[i][i] != move.getSymbol()) isDiagonal = false;
            if (grid[i][grid.length - i - 1] != move.getSymbol()) isOppDiagonal = false;
        }

        return isHorizontal || isVertical || isDiagonal || isOppDiagonal;
    }

    public boolean isFull() {
        return cntMoves == 0;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Symbol[] chars : grid) {
            for (Symbol symbol : chars) {
                if (symbol != Symbol.O && symbol != Symbol.X) symbol = Symbol.EMPTY;
                b.append(symbol).append("\t");
            }
            b.append("\n");
        }

        return b.toString();
    }
}

package tictactoe;

public class Move {
    private final Player player;
    private final int x;
    private final int y;
    private final Symbol symbol;

    public Move(Player player, int x, int y, Symbol symbol) {
        this.player = player;
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

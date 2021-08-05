package tictactoe;

public enum Symbol {
    EMPTY("."), O("0"), X("X");

    private String val;

    private Symbol(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}

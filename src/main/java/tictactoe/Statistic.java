package tictactoe;

public class Statistic {

    private int win;
    private int lose;
    private int draw;

    public Statistic() {
        this(0, 0, 0);
    }

    public Statistic(int win, int lose, int draw) {
        this.win = win;
        this.lose = lose;
        this.draw = draw;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public void won() {
        win++;
    }

    public void lost() {
        lose++;
    }

    public void draw() {
        draw++;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "win=" + win +
                ", lose=" + lose +
                ", draw=" + draw +
                '}';
    }
}

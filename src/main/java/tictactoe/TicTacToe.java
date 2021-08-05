package tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        Board board = new Board(3);

        Player first = new Player("Antonie");
        Player second = new Player("Clement");
        Game game = new Game(first, second, board);

        game.play();

    }
}

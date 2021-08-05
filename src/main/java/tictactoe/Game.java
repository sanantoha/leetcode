package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Player first;
    private final Player second;
    private final Board board;
    private final List<Move> moves;

    private Status status;

    private final Scanner scanner;

    public Game(Player first, Player second, Board board) {
        this.first = first;
        this.second = second;
        this.board = board;
        this.moves = new ArrayList<>();
        this.status = Status.IN_PROGRESS;
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        int idx = 0;
        while (status == Status.IN_PROGRESS) {
            System.out.println(board);

            if (board.isFull()) {
                status = Status.DRAW;
                break;
            }
            Move nextMove = null;
            if (idx % 2 == 0) {
                nextMove = readMove(first, Symbol.X);
            } else {
                nextMove = readMove(second, Symbol.O);
            }
            if (!setMoveToBoard(nextMove)) continue;
            moves.add(nextMove);

            status = checkWinner(nextMove);
            idx++;
        }

        if (status == Status.X_WON) {
            first.getStats().won();
            second.getStats().lost();
            System.out.println("First player won " + first);
        } else if (status == Status.O_WON) {
            first.getStats().lost();
            second.getStats().won();
            System.out.println("Second player won " + second);
        } else {
            first.getStats().draw();
            second.getStats().draw();
            System.out.println("Draw");
        }

        System.out.println("Game is over");
    }

    private Status checkWinner(Move nextMove) {
        if (board.isWinnerMove(nextMove)) {
            if (nextMove.getSymbol() == Symbol.X) return Status.X_WON;
            else return Status.O_WON;
        }
        return Status.IN_PROGRESS;
    }

    private boolean setMoveToBoard(Move move) {
        try {
            board.set(move.getX(), move.getY(), move.getSymbol());
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void dispose() {
        scanner.close();
    }

    private Move readMove(Player player, Symbol symbol) {
        System.out.println("player " + player.getName() + " enter X: ");
        int x = scanner.nextInt();
        System.out.println("player " + player.getName() + " enter Y: ");
        int y = scanner.nextInt();
        return new Move(player, x, y, symbol);
    }

}

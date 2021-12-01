package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegions3 {

    // O(w * h) time | O(1) space
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int i = 0; i < board.length; i++) {
            markAsKeepZero(board, i, 0);
            markAsKeepZero(board, i, board[i].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            markAsKeepZero(board, 0, i);
            markAsKeepZero(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private static void markAsKeepZero(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;

        board[row][col] = 'Y';

        for (int[] pair : getNeighbors(board, row, col)) {
            int fRow = pair[0];
            int fCol = pair[1];
            if (board[fRow][fCol] == 'O') {
                markAsKeepZero(board, fRow, fCol);
            }
        }
    }

    private static List<int[]> getNeighbors(char[][] board, int row, int col) {
        List<int[]> neighbors = new ArrayList<>();

        if (row > 0) neighbors.add(new int[] {row - 1, col});
        if (col > 0) neighbors.add(new int[] {row, col - 1});
        if (row + 1 < board.length) neighbors.add(new int[] {row + 1, col});
        if (col + 1 < board[row].length) neighbors.add(new int[] {row, col + 1});

        return neighbors;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'}
                ,{'X','O','O','X'}
                ,{'X','X','O','X'}
                ,{'X','O','X','X'}
        };

        solve(board);

        System.out.println(Arrays.deepToString(board));

        System.out.println("=========================");

        char[][] board1 = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };

        solve(board1);

        System.out.println(Arrays.deepToString(board1));

        System.out.println("=========================");

        char[][] board2 = {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };

        solve(board2);

        System.out.println(Arrays.deepToString(board2));
    }
}

package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegions2 {

    // O(w * h) time | O(1) space
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int row = 0; row < board.length; row++) {
            dfs(board, row, 0);
            dfs(board, row, board[row].length - 1);
        }

        for (int col = 0; col < board[0].length; col++) {
            dfs(board, 0, col);
            dfs(board, board.length - 1, col);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '*') board[row][col] = 'X';
                else if (board[row][col] == 'X') board[row][col] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'X') return;
        board[row][col] = '*';

        List<int[]> neighbors = getNeighbors(board, row, col);

        for (int[] neighbor : neighbors) {
            int nextRow = neighbor[0];
            int nextCol = neighbor[1];
            if (board[nextRow][nextCol] == 'X') {
                dfs(board, nextRow, nextCol);
            }
        }
    }

    private static List<int[]> getNeighbors(char[][] board, int row, int col) {
        List<int[]> res = new ArrayList<>();

        if (row > 0) {
            res.add(new int[] {row - 1, col});
        }
        if (col > 0) {
            res.add(new int[] {row, col - 1});
        }
        if (row + 1 < board.length) {
            res.add(new int[] {row + 1, col});
        }
        if (col + 1 < board[row].length) {
            res.add(new int[] {row, col + 1});
        }

        return res;
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

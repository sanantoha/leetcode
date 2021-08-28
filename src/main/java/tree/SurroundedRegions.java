package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }

        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;
        board[row][col] = '*';

        for (int[] fut : getNextSteps(board, row, col)) {
            int futRow = fut[0];
            int futCol = fut[1];
            if (board[futRow][futCol] == 'O') {
                dfs(board, futRow, futCol);
            }
        }

    }

    private static List<int[]> getNextSteps(char[][] board, int row, int col) {
        List<int[]> res = new ArrayList<>();
        if (row - 1 >= 0) res.add(new int[] {row - 1, col});
        if (col - 1 >= 0) res.add(new int[] {row, col - 1});
        if (row + 1 < board.length) res.add(new int[] {row + 1, col});
        if (col + 1 < board[row].length) res.add(new int[] {row, col + 1});
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

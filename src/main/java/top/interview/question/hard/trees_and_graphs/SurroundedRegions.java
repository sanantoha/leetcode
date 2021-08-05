package top.interview.question.hard.trees_and_graphs;

import java.util.Arrays;

public class SurroundedRegions {

    private static int[][] paths = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

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
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == '*') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') return;

        board[row][col] = '*';

        for (int[] path: paths) {
            int futRow = path[0] + row;
            int futCol = path[1] + col;

            if (futRow >= 0 && futRow < board.length &&
                futCol >=0 && futCol < board[0].length &&
                    board[futRow][futCol] == 'O') {
                    dfs(board, futRow, futCol);
            }
        }
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

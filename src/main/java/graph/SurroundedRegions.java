package graph;

import java.util.*;

public class SurroundedRegions {

    // O(w * h) time | O(w * h) space
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean rowIsBorder = row == 0 || row == board.length - 1;
                boolean colIsBorder = col == 0 || col == board[row].length - 1;
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder || board[row][col] != 'O') {
                    continue;
                }

                dfs(board, row, col);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void dfs(char[][] board, int row, int col) {

        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[] {row, col});

        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int currRow = p[0];
            int currCol = p[1];

            board[currRow][currCol] = '*';

            for (int[] fut : getNextSteps(board, currRow, currCol)) {
                int futRow = fut[0];
                int futCol = fut[1];

                if (board[futRow][futCol] != 'O') {
                    continue;
                }
                stack.push(new int[] {futRow, futCol});
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

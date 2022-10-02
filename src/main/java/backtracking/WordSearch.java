package backtracking;

public class WordSearch {

    // O(n * 3 ^ l) time | O(l) space - where l is length of word and n is total amount of cells
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int row, int col, int count, String word) {
        if (count == word.length()) return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length ||
            word.charAt(count) != board[row][col]) {
            return false;
        }

        char tmp = board[row][col];
        board[row][col] = ' ';

        boolean found = dfs(board, row - 1, col, count + 1, word) ||
            dfs(board, row + 1, col, count + 1, word) ||
            dfs(board, row, col - 1, count + 1, word) ||
            dfs(board, row, col + 1, count + 1, word);

        board[row][col] = tmp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCE";

        System.out.println(exist(board, word));


        System.out.println("========================");


        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        String word1 = "ABCESEEEFS";

        System.out.println(exist(board1, word1));


        System.out.println("===========================");


        String word2 = "ABCEFSADEESE";
        System.out.println(exist(board1, word2));


        System.out.println("==========================");

        System.out.println(!exist(board1, "ABCEV"));
    }
}

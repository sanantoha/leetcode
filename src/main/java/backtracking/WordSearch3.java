package backtracking;

public class WordSearch3 {

    // O(n * 3 ^ l) time | O(l) space - where l is length of word and n is total amount of cells
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int wordIdx) {
        if (wordIdx == word.length()) return true;

        if (col < 0 || row < 0 || row >= board.length || col >= board[row].length ||
            board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        char tmp = board[row][col];
        board[row][col] = ' ';

        boolean isExists = dfs(board, word, row - 1, col, wordIdx + 1) ||
                dfs(board, word, row, col - 1, wordIdx + 1) ||
                dfs(board, word, row + 1, col, wordIdx + 1) ||
                dfs(board, word, row, col + 1, wordIdx + 1);

        board[row][col] = tmp;
        return isExists;
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

        System.out.println(exist(board1, "ABCEV"));
    }
}

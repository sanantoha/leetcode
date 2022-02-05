package backtracking;

public class WordSearch6 {

    // O(w * h * 3 ^ l) time | O(l) time - where l length of the word
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int idx, int row, int col) {
        if (word.length() == idx) return true;

        if (col < 0 || row < 0 || row >= board.length || col >= board[row].length ||
            board[row][col] != word.charAt(idx)) return false;

        char tmp = board[row][col];
        board[row][col] = ' ';

        boolean isCharFound = dfs(board, word, idx + 1, row - 1, col) ||
                dfs(board, word, idx + 1, row, col - 1) ||
                dfs(board, word, idx + 1, row + 1, col) ||
                dfs(board, word, idx + 1, row, col + 1);

        board[row][col] = tmp;

        return isCharFound;
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

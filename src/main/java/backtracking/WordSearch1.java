package backtracking;

public class WordSearch1 {

    // O(n) time | O(n) space
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||
            word.charAt(count) != board[i][j]) {
            return false;
        }

        char tmp = board[i][j];
        board[i][j] = ' ';

        boolean found = dfs(board, i - 1, j, count + 1, word) ||
                dfs(board, i, j - 1, count + 1, word) ||
                dfs(board, i + 1, j, count + 1, word) ||
                dfs(board, i, j + 1, count + 1, word);
        board[i][j] = tmp;
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

        System.out.println(exist(board1, "ABCEV"));
    }
}

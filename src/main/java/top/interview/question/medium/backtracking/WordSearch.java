package top.interview.question.medium.backtracking;


class Solution4 {

    private static int[][] steps = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (word.charAt(0) == board[i][j]) {
                    if (search(board, word, i, j)) return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int currX, int currY) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        return dfs(board, visited, word,"" + word.charAt(0), 1, currX, currY);
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, String result, int wordInd, int currX, int currY) {
        if (word.length() == result.length()) {
            return word.equals(result);
        }
        visited[currX][currY] = true;

        for (int i = 0; i < steps.length; i++) {
            int futX = currX + steps[i][0];
            int futY = currY + steps[i][1];

            if (futX >= 0 && futX < board.length &&
                futY >= 0 && futY < board[0].length &&
                !visited[futX][futY] &&
                board[futX][futY] == word.charAt(wordInd)) {
                if (dfs(board, visited, word, result + word.charAt(wordInd), wordInd + 1, futX, futY)) return true;
            }
        }
        visited[currX][currY] = false;
        return false;
    }

}

public class WordSearch {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCE";

        System.out.println(s.exist(board, word));


        System.out.println("========================");


        char[][] board1 = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        String word1 = "ABCESEEEFS";

        System.out.println(s.exist(board1, word1));


        System.out.println("===========================");


        String word2 = "ABCEFSADEESE";
        System.out.println(s.exist(board1, word2));


        System.out.println("==========================");

        System.out.println(s.exist(board1, "ABCEV"));
    }
}

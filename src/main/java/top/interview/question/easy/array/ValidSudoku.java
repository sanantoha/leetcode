package top.interview.question.easy.array;

import java.util.Arrays;

class Solution9 {

    public static int BOX_SIZE = 3;

    public int getInt(char c) {
        return Character.getNumericValue(c);
    }

    public boolean isValid(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int vi = getInt(arr[i]);
            if (vi == -1) continue;
            if (vi > 9) return false;

            for (int j = 0; j < arr.length; j++) {
                int vj = getInt(arr[j]);
                if (vj == -1) continue;
                if (i != j) {
                    if (vi == vj) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public char[] createArrFromSubBox(char[][] board, int r, int c) {
        char[] arr = new char[BOX_SIZE * BOX_SIZE];
        int z = 0;
        for (int i = r; i < r + BOX_SIZE; i++) {
            for (int j = c; j < c + BOX_SIZE; j++) {
                arr[z++] = board[i][j];
            }
        }
        return arr;
    }

    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            if (!isValid(chars)) return false;
        }

        for (int i = 0; i < board.length; i++) {
            char[] arr = new char[board[i].length];
            for (int j = 0; j < board[i].length; j++) {
                arr[j] = board[j][i];
            }
            if (!isValid(arr)) return false;
        }

        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                int r = i * BOX_SIZE;
                int c = j * BOX_SIZE;
                char[] arr = createArrFromSubBox(board, r, c);
                if (!isValid(arr)) return false;
            }
        }

        return true;
    }
}

public class ValidSudoku {
    public static void main(String[] args) {
        Solution9 s = new Solution9();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(s.isValidSudoku(board));
//        System.out.println(Arrays.toString(s.createArrFromSubBox(board, 6, 3)));
    }
}

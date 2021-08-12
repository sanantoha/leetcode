package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int n, int row, List<Integer> cols, List<List<Integer>> res) {
        if (n == row) {
            res.add(new ArrayList<>(cols));
            return;
        }

        for (int col = 0; col < n; col++) {
            cols.add(col);
            if (isValid(cols)) {
                backtrack(n, row + 1, cols, res);
            }
            cols.remove(cols.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> cols) {
        // 1 0
        int rowId = cols.size() - 1; // 1
        for (int i = 0; i < rowId; i++) { // i = 0
            int diff = Math.abs(cols.get(i) - cols.get(rowId)); // 1
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(nQueens(4));
    }
}

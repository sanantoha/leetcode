package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraverse1 {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> res = new ArrayList<>();
        if (array == null || array.size() == 0) return res;

        int row = 0;
        int col = 0;
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;

        boolean isGoingDown = true;

        while (!isOutOfBound(row, col, height, width)) {
            res.add(array.get(row).get(col));
            if (isGoingDown) {
                if (col == 0 || row == height) {
                    isGoingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    row--;
                    col++;
                }
            }
        }
        return res;
    }

    private static boolean isOutOfBound(int row, int col, int height, int width) {
        return row < 0 || col < 0 || row > height || col > width;
    }


    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));

        System.out.println(zigzagTraverse(test));
    }
}

package graph;

import java.util.*;

public class LargestIsland1 {

    public static int largestIsland(int[][] matrix) {
        return -1;
    }


    public static int largestIsland1(int[][] matrix) {
        return -1;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0}
        };
        int expected = 8;

        int actual = largestIsland(matrix);
        System.out.println(actual);
        System.out.println(actual == expected);

        actual = largestIsland1(matrix);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}

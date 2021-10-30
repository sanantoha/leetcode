package graph;

import java.util.List;

public class RiverSizes6 {

    public static List<Integer> riverSizes(int[][] matrix) {
        return null;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        System.out.println(riverSizes(matrix));
    }
}

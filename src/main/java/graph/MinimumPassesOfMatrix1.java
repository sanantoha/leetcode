package graph;

/**
 * https://www.algoexpert.io/questions/Minimum%20Passes%20Of%20Matrix
 */
public class MinimumPassesOfMatrix1 {

    public static int minimumPassesOfMatrix(int[][] matrix) {
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        System.out.println(actual);
        System.out.println(expected == actual);
    }
}

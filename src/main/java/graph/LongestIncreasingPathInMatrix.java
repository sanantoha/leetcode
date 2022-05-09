package graph;

public class LongestIncreasingPathInMatrix {

    public static int longestIncreasingPath(int[][] matrix) {
        return -1;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/350/trees-and-graphs/2049/
     * @param args
     */
    public static void main(String[] args) {
        int[][] input = {
                {9,9,4},{6,6,8},{2,1,1}
        };
        System.out.println(longestIncreasingPath(input)); // 4

        int[][] input1 = {
                {3,4,5},{3,2,6},{2,2,1}
        };
        System.out.println(longestIncreasingPath(input1)); // 4
    }
}

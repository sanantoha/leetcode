package sorting;

import java.util.Arrays;

public class MergeIntervals1 {

    public static int[][] merge(int[][] intervals) {
        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 5},
                {3, 7},
                {4, 6},
                {6, 8}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));


        int[][] intervals1 = {
                {1,3},{2,6},{8,10},{15,18}
        };

        System.out.println(Arrays.deepToString(merge(intervals1)));


        int[][] intervals2 = {
                {1,4},{4,5}
        };

        System.out.println(Arrays.deepToString(merge(intervals2)));
    }
}

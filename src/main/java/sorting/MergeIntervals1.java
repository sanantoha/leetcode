package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals1 {

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) return null;
        if (intervals.length < 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},{2,6},{8,10},{15,18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));


        int[][] intervals1 = {
                {1,4},{4,5}
        };

        System.out.println(Arrays.deepToString(merge(intervals1)));
    }
}

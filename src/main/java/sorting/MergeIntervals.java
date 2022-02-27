package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    // O(n * log(n)) time | O(n) space
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] curr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = curr[0];
            int currEnd = curr[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currEnd >= nextStart) {
                curr[1] = Math.max(currEnd, nextEnd);
            } else {
                res.add(intervals[i]);
                curr = intervals[i];
            }
        }

        return res.toArray(new int[0][0]);
    }

    // O(n * log(n)) time | O(n) space
    public static int[][] merge1(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge1(intervals)));

        int[][] intervals1 = {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };

        System.out.println(Arrays.deepToString(merge(intervals1)));
        System.out.println(Arrays.deepToString(merge1(intervals1)));

        int[][] intervals2 = {
                {4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}
        };

        System.out.println(Arrays.deepToString(merge(intervals2)));
        System.out.println(Arrays.deepToString(merge1(intervals2)));
    }
}

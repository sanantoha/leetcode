package top.interview.question.medium.sorting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution5 {
    public int[][] merge0(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] currInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int currIntervalStart = currInterval[0];
            int currIntervalEnd = currInterval[1];
            int nextIntervalStart = intervals[i][0];
            int nextIntervalEnd = intervals[i][1];

            if (currIntervalEnd >= nextIntervalStart) {
                currInterval[1] = Math.max(currIntervalEnd, nextIntervalEnd);
            } else {
                currInterval = intervals[i];
                result.add(currInterval);
            }
        }

        return result.toArray(new int[0][0]);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}

public class MergeInterval {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        System.out.println(Arrays.deepToString(s.merge(intervals)));

        int[][] intervals1 = {
                {2,3},{4,5},{6,7},{8,9},{1,10}
        };

        System.out.println(Arrays.deepToString(s.merge(intervals1)));

        int[][] intervals2 = {
                {4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}
        };

        System.out.println(Arrays.deepToString(s.merge(intervals2)));
    }
}

package dynamic;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Disk%20Stacking
 */
public class DiskStacking {

    // O(n ^ 2) time | O(n) space
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        if (disks == null || disks.size() == 0) return Collections.emptyList();

        disks.sort(Comparator.comparingInt(disk -> disk[2]));

        int[] heights = new int[disks.size()];
        for (int i = 0; i < disks.size(); i++) {
            heights[i] = disks.get(i)[2];
        }

        int[] prev = new int[disks.size()];
        Arrays.fill(prev, -1);

        int maxIdx = 0;

        for (int i = 1; i < disks.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (less(disks.get(j), disks.get(i)) && heights[i] <= heights[j] + disks.get(i)[2]) {
                    heights[i] = heights[j] + disks.get(i)[2];
                    prev[i] = j;
                }
            }
            if (heights[maxIdx] < heights[i]) {
                maxIdx = i;
            }
        }

        return buildList(disks, prev, maxIdx);
    }

    private static List<Integer[]> buildList(List<Integer[]> disks, int[] prev, int maxIdx) {
        List<Integer[]> res = new ArrayList<>();
        int idx = maxIdx;

        while (idx >= 0) {
            res.add(disks.get(idx));
            idx = prev[idx];
        }
        Collections.reverse(res);
        return res;
    }

    private static boolean less(Integer[] disk1, Integer[] disk2) {
        return (disk1[0] < disk2[0] && disk1[1] < disk2[1] && disk1[2] < disk2[2]);
    }

    public static void main(String[] args) {
        List<Integer[]> input = new ArrayList<Integer[]>();
        input.add(new Integer[] {2, 1, 2});
        input.add(new Integer[] {3, 2, 3});
        input.add(new Integer[] {2, 2, 8});
        input.add(new Integer[] {2, 3, 4});
        input.add(new Integer[] {2, 2, 1});
        input.add(new Integer[] {4, 4, 5});
        List<Integer[]> expected = new ArrayList<Integer[]>();
        expected.add(new Integer[] {2, 1, 2});
        expected.add(new Integer[] {3, 2, 3});
        expected.add(new Integer[] {4, 4, 5});

        List<Integer[]> actual = diskStacking(input);
        actual.forEach(disk -> {
            System.out.println(Arrays.toString(disk));
        });
        System.out.println(compare(actual, expected));
    }

    private static boolean compare(List<Integer[]> arr1, List<Integer[]> arr2) {
        if (arr1.size() != arr2.size()) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr1.get(i).length; j++) {
                if (!arr1.get(i)[j].equals(arr2.get(i)[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}

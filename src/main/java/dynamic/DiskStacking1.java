package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Disk%20Stacking
 */
public class DiskStacking1 {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        // Write your code here.
        return Collections.emptyList();
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

        System.out.println(compare(diskStacking(input), expected));
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

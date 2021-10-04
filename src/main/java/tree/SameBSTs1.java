package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs1 {

    static class Pair {
        List<Integer> lessArr;
        List<Integer> gtEqArr;

        public Pair(List<Integer> lessArr, List<Integer> gtEqArr) {
            this.lessArr = lessArr;
            this.gtEqArr = gtEqArr;
        }
    }

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0)) return true;
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (arrayOne.get(0) != arrayTwo.get(0)) return false;

        Pair one = partition(arrayOne);
        Pair two = partition(arrayTwo);

        return sameBsts(one.lessArr, two.lessArr) && sameBsts(one.gtEqArr, two.gtEqArr);
    }

    private static Pair partition(List<Integer> array) {
        List<Integer> lessArr = new ArrayList<>();
        List<Integer> gtEqArr = new ArrayList<>();

        for (int i = 1; i < array.size(); i++) {
            if (array.get(0) < array.get(i)) {
                lessArr.add(array.get(i));
            } else {
                gtEqArr.add(array.get(i));
            }
        }

        return new Pair(lessArr, gtEqArr);
    }

    // O(n ^ 2) time | O(d) space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int idxOne, int idxTwo, int minValue, int maxValue) {
        if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo;
        if (arrayOne.get(idxOne).intValue() != arrayTwo.get(idxTwo).intValue()) return false;

        int smallerIdxOne = getSmallerIdx(arrayOne, idxOne, minValue);
        int greaterIdxOne = getGreaterOrEqualIdx(arrayOne, idxOne, maxValue);
        int smallerIdxTwo = getSmallerIdx(arrayTwo, idxTwo, minValue);
        int greaterIdxTwo = getGreaterOrEqualIdx(arrayTwo, idxTwo, maxValue);

        int currValue = arrayOne.get(idxOne);

        return areSameBsts(arrayOne, arrayTwo, smallerIdxOne, smallerIdxTwo, minValue, currValue) &&
                areSameBsts(arrayOne, arrayTwo, greaterIdxOne, greaterIdxTwo, currValue, maxValue);
    }

    private static int getSmallerIdx(List<Integer> array, int startIdx, int minValue) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(i) >= minValue && array.get(i) < array.get(startIdx)) {
                return i;
            }
        }
        return -1;
    }

    private static int getGreaterOrEqualIdx(List<Integer> array, int startIdx, int maxValue) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(i) < maxValue && array.get(i) >= array.get(startIdx)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = new ArrayList<Integer>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        List<Integer> arrayTwo = new ArrayList<Integer>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(arrayOne, arrayTwo));
        System.out.println(sameBsts1(arrayOne, arrayTwo));
    }
}

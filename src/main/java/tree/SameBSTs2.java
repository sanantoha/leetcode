package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs2 {

    static class Pair {
        List<Integer> less;
        List<Integer> greaterOrEqual;

        public Pair(List<Integer> one, List<Integer> two) {
            this.less = one;
            this.greaterOrEqual = two;
        }
    }

    // O(n ^ 2) time | O(n ^ 2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0))
            return true;
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) {
            return false;
        }

        Pair pairOne = partition(arrayOne);
        Pair pairTwo = partition(arrayTwo);

        return sameBsts(pairOne.less, pairTwo.less) && sameBsts(pairOne.greaterOrEqual, pairTwo.greaterOrEqual);
    }

    private static Pair partition(List<Integer> lst) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greaterOrEqual = new ArrayList<>();

        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(i) < lst.get(0)) {
                less.add(lst.get(i));
            } else {
                greaterOrEqual.add(lst.get(i));
            }
        }

        return new Pair(less, greaterOrEqual);
    }

    // O(n ^ 2) time | O(d) space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int idxOne, int idxTwo, int minValue, int maxValue) {
        if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo;
        if (arrayOne.get(idxOne).intValue() != arrayTwo.get(idxTwo).intValue()) return false;

        int smallerIdxOne = getSmallerIdx(arrayOne, idxOne, minValue);
        int greaterOrEqualOne = getGreaterOrEqualIdx(arrayOne, idxOne, maxValue);
        int smallerIdxTwo = getSmallerIdx(arrayTwo, idxTwo, minValue);
        int greaterOrEqualTwo = getGreaterOrEqualIdx(arrayTwo, idxTwo, maxValue);

        int currValue = arrayOne.get(idxOne);

        return areSameBsts(arrayOne, arrayTwo, smallerIdxOne, smallerIdxTwo, minValue, currValue) &&
                areSameBsts(arrayOne, arrayTwo, greaterOrEqualOne, greaterOrEqualTwo, currValue, maxValue);
    }

    private static int getSmallerIdx(List<Integer> lst, int idx, int minValue) {

        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(i) < lst.get(idx) && lst.get(i) >= minValue) return i;
        }
        return -1;
    }

    private static int getGreaterOrEqualIdx(List<Integer> lst, int idx, int maxValue) {
        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(i) >= lst.get(idx) && lst.get(i) < maxValue) return i;
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

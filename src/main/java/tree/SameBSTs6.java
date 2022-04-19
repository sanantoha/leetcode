package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs6 {

    // O((n1 + n2) ^ 2) time | O((n1 + n2) ^ 2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0)) {
            return true;
        }
        if ((arrayOne == null || arrayOne.size() == 0) || (arrayTwo == null || arrayTwo.size() == 0)) {
            return false;
        }
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) {
            return false;
        }

        Pair pOne = partition(arrayOne);
        Pair pTwo = partition(arrayTwo);

        return sameBsts(pOne.less, pTwo.less) && sameBsts(pOne.greaterOrEqual, pTwo.greaterOrEqual);
    }

    private static Pair partition(List<Integer> lst) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greaterOrEqual = new ArrayList<>();

        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(0) < lst.get(i)) {
                less.add(lst.get(i));
            } else {
                greaterOrEqual.add(lst.get(i));
            }
        }
        return new Pair(less, greaterOrEqual);
    }

    static class Pair {
        List<Integer> less;
        List<Integer> greaterOrEqual;

        public Pair(List<Integer> less, List<Integer> greaterOrEqual) {
            this.less = less;
            this.greaterOrEqual = greaterOrEqual;
        }
    }

    // O((n1 + n2) ^ 2) time | O(n1 + n2) space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0)) {
            return true;
        }
        if ((arrayOne == null || arrayOne.size() == 0) || (arrayTwo == null || arrayTwo.size() == 0)) {
            return false;
        }
        return sameBsts1(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean sameBsts1(List<Integer> arrayOne,
                                     List<Integer> arrayTwo,
                                     int idxOne,
                                     int idxTwo,
                                     int minVal,
                                     int maxVal) {
        if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo;
        if (arrayOne.get(idxOne).intValue() != arrayTwo.get(idxTwo).intValue()) {
            return false;
        }

        int lessIdxOne = getLessIdx(arrayOne, idxOne, minVal);
        int greaterOrEqualIdxOne = getGreaterOrEqualIdx(arrayOne, idxOne, maxVal);
        int lessIdxTwo = getLessIdx(arrayTwo, idxTwo, minVal);
        int greaterOrEqualIdxTwo = getGreaterOrEqualIdx(arrayTwo, idxTwo, maxVal);

        int value = arrayOne.get(idxOne);

        return sameBsts1(arrayOne, arrayTwo, lessIdxOne, lessIdxTwo, minVal, value) &&
                sameBsts1(arrayOne, arrayTwo, greaterOrEqualIdxOne, greaterOrEqualIdxTwo, value, maxVal);
    }

    private static int getLessIdx(List<Integer> lst, int idx, int minVal) {
        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(idx) > lst.get(i) && lst.get(i) >= minVal) return i;
        }
        return -1;
    }

    private static int getGreaterOrEqualIdx(List<Integer> lst, int idx, int maxVal) {
        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(idx) <= lst.get(i) && lst.get(i) < maxVal) return i;
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

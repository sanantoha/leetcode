package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SameBSTs3 {

    static class Pair {
        List<Integer> less;
        List<Integer> greaterOrEqual;

        public Pair(List<Integer> less, List<Integer> greaterOrEqual) {
            this.less = less;
            this.greaterOrEqual = greaterOrEqual;
        }
    }

    // O(n ^ 2) time | O(n ^ 2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne == null && arrayTwo == null) return true;
        if (arrayOne == null || arrayTwo == null) return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (!Objects.equals(arrayOne.get(0), arrayTwo.get(0))) return false;

        Pair pOne = partition(arrayOne);
        Pair pTwo = partition(arrayTwo);

        return sameBsts(pOne.less, pTwo.less) && sameBsts(pOne.greaterOrEqual, pTwo.greaterOrEqual);
    }

    private static Pair partition(List<Integer> lst) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greaterOrEqual = new ArrayList<>();

        for (int i = 1; i < lst.size(); i++) {
            if (lst.get(0) > lst.get(i)) {
                less.add(lst.get(i));
            } else {
                greaterOrEqual.add(lst.get(i));
            }
        }

        return new Pair(less, greaterOrEqual);
    }

    // O(n ^ 2) time | O(d) space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne == null && arrayTwo == null) return true;
        if (arrayOne == null || arrayTwo == null) return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne,
                                       List<Integer> arrayTwo,
                                       int idxOne,
                                       int idxTwo,
                                       int minVal,
                                       int maxVal) {
        if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo;
        if (!Objects.equals(arrayOne.get(idxOne), arrayTwo.get(idxTwo))) return false;

        int currVal = arrayOne.get(idxOne);
        int lessIdxOne = getLessIdx(arrayOne, idxOne, minVal);
        int lessIdxTwo = getLessIdx(arrayTwo, idxTwo, minVal);
        int greaterOrEqualIdxOne = getGreaterOrEqualsIdx(arrayOne, idxOne, maxVal);
        int greaterOrEqualIdxTwo = getGreaterOrEqualsIdx(arrayTwo, idxTwo, maxVal);

        return areSameBsts(arrayOne, arrayTwo, lessIdxOne, lessIdxTwo, minVal, currVal) &&
            areSameBsts(arrayOne, arrayTwo, greaterOrEqualIdxOne, greaterOrEqualIdxTwo, currVal, maxVal);
    }

    private static int getLessIdx(List<Integer> lst, int idx, int minVal) {
        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(i) < lst.get(idx) && lst.get(i) >= minVal)
                return i;
        }
        return -1;
    }

    private static int getGreaterOrEqualsIdx(List<Integer> lst, int idx, int maxVal) {
        for (int i = idx + 1; i < lst.size(); i++) {
            if (lst.get(i) >= lst.get(idx) && lst.get(i) < maxVal) {
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

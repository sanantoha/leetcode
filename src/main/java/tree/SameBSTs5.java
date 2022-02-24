package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs5 {

    // O((a1 + a2) ^ 2) time | O((a1 + a2) ^ 2) time
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0)) {
            return true;
        }
        if ((arrayOne == null || arrayOne.size() == 0) || (arrayTwo == null || arrayTwo.size() == 0)) {
            return false;
        }
        if (arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) return false;

        Pair pOne = partition(arrayOne);
        Pair pTwo = partition(arrayTwo);

        return sameBsts(pOne.fst, pTwo.fst) && sameBsts(pOne.snd, pTwo.snd);
    }

    private static Pair partition(List<Integer> arrayOne) {
        List<Integer> less = new ArrayList<>();
        List<Integer> greaterOrEqual = new ArrayList<>();

        for (int i = 1; i < arrayOne.size(); i++) {
            if (arrayOne.get(0) < arrayOne.get(i)) {
                less.add(arrayOne.get(i));
            } else {
                greaterOrEqual.add(arrayOne.get(i));
            }
        }
        return new Pair(less, greaterOrEqual);
    }

    static class Pair {
        List<Integer> fst;
        List<Integer> snd;

        public Pair(List<Integer> fst, List<Integer> snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if ((arrayOne == null || arrayOne.size() == 0) && (arrayTwo == null || arrayTwo.size() == 0)) {
            return true;
        }
        if ((arrayOne == null || arrayOne.size() == 0) || (arrayTwo == null || arrayTwo.size() == 0)) {
            return false;
        }
        return areSameBsts1(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // O((a1 + a2) ^ 2) time | O(a1 + a2) space
    private static boolean areSameBsts1(List<Integer> arrayOne,
                                        List<Integer> arrayTwo,
                                        int idxOne,
                                        int idxTwo,
                                        int minValue,
                                        int maxValue) {
        if (idxOne == -1 || idxTwo == -1) {
            return idxOne == idxTwo;
        }
        if (arrayOne.get(idxOne).intValue() != arrayTwo.get(idxTwo).intValue()) {
            return false;
        }

        int lessIdxOne = getLessIdx(arrayOne, idxOne, minValue);
        int lessIdxTwo = getLessIdx(arrayTwo, idxTwo, minValue);
        int greaterOrEqualIdxOne = getGreaterOrEqual(arrayOne, idxOne, maxValue);
        int greaterOrEqualIdxTwo = getGreaterOrEqual(arrayTwo, idxTwo, maxValue);
        int value = arrayOne.get(idxOne);

        return areSameBsts1(arrayOne, arrayTwo, lessIdxOne, lessIdxTwo, minValue, value) &&
                areSameBsts1(arrayOne, arrayTwo, greaterOrEqualIdxOne, greaterOrEqualIdxTwo, value, maxValue);
    }

    private static int getLessIdx(List<Integer> array, int idx, int minValue) {
        for (int i = idx + 1; i < array.size(); i++) {
            if (array.get(idx) > array.get(i) && array.get(i) >= minValue) {
                return i;
            }
        }
        return -1;
    }

    private static int getGreaterOrEqual(List<Integer> array, int idx, int maxValue) {
        for (int i = idx + 1; i < array.size(); i++) {
            if (array.get(idx) <= array.get(i) && array.get(i) < maxValue) {
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

package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SameBSTs {

    // O(n ^ 2) time | O(n ^ 2) space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne == null && arrayTwo == null) return true;
        if (arrayOne == null || arrayTwo == null) return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }
        if (arrayOne.size() != arrayTwo.size()) return false;
        if (!Objects.equals(arrayOne.get(0), arrayTwo.get(0))) return false;

        Pair fst = partition(arrayOne);
        Pair snd = partition(arrayTwo);

        return sameBsts(fst.arrayOne, snd.arrayOne) && sameBsts(fst.arrayTwo, snd.arrayTwo);
    }

    private static Pair partition(List<Integer> array) {
        List<Integer> fst = new ArrayList<>();
        List<Integer> snd = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < array.get(0)) {
                fst.add(array.get(i));
            } else {
                snd.add(array.get(i));
            }
        }
        return new Pair(fst, snd);
    }

    static class Pair {
        List<Integer> arrayOne;
        List<Integer> arrayTwo;

        public Pair(List<Integer> arrayOne, List<Integer> arrayTwo) {
            this.arrayOne = arrayOne;
            this.arrayTwo = arrayTwo;
        }
    }


// =======================================================================================================

    // O(n ^ 2) time | O(d) space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne == null && arrayTwo == null) return true;
        if (arrayOne == null || arrayTwo == null) return false;
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int idxOne, int idxTwo, int minValue, int maxValue) {

        if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo;
        if (arrayOne.get(idxOne).intValue() != arrayTwo.get(idxTwo).intValue()) return false;

        int smallerIdxOne = getSmallerIdx(arrayOne, idxOne, minValue);
        int greaterIdxOne = getBiggerOrEqualsIdx(arrayOne, idxOne, maxValue);
        int smallerIdxTwo = getSmallerIdx(arrayTwo, idxTwo, minValue);
        int greaterIdxTwo = getBiggerOrEqualsIdx(arrayTwo, idxTwo, maxValue);


        int curr = arrayOne.get(idxOne);
        return areSameBsts(arrayOne, arrayTwo, smallerIdxOne, smallerIdxTwo, minValue, curr) &&
                areSameBsts(arrayOne, arrayTwo, greaterIdxOne, greaterIdxTwo, curr, maxValue);
    }

    private static int getSmallerIdx(List<Integer> array, int startIdx, int minVal) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(startIdx) > array.get(i) && array.get(i) >= minVal) return i;
        }
        return -1;
    }

    private static int getBiggerOrEqualsIdx(List<Integer> array, int startIdx, int maxVal) {
        for (int i = startIdx + 1; i < array.size(); i++) {
            if (array.get(startIdx) <= array.get(i) && array.get(i) < maxVal) return i;
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

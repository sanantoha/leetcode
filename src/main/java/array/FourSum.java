package array;

import java.util.*;

public class FourSum {

    // O(n ^ 4) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        if (array == null || array.length < 4) return result;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    for (int z = k + 1; z < array.length; z++) {
                        if (array[i] + array[j] + array[k] + array[z] == targetSum) {
                            result.add(new Integer[] {array[i], array[j], array[k], array[z]});
                        }
                    }
                }
            }
        }

        return result;
    }

    // Avg: O(n ^ 2) time | O(n ^ 2) space
    // Worst: O(n ^ 3) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum1(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        if (array == null || array.length < 4) return result;

        Map<Integer, List<Integer[]>> map = new HashMap<>();
        for (int i = 1; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {
                int compensate = targetSum - (array[i] + array[j]);
                List<Integer[]> lst = map.get(compensate);
                if (lst != null) {
                    for (Integer[] pair : lst) {
                        result.add(new Integer[] {array[i], array[j], pair[0], pair[1]});
                    }
                }
            }

            for (int k = i - 1; k >= 0; k--) {
                int sum = array[i] + array[k];
                List<Integer[]> lst = map.getOrDefault(sum, new ArrayList<>());
                lst.add(new Integer[] {array[i], array[k]});
                map.put(sum, lst);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 4, -1, 1, 2};

        print(fourNumberSum(arr, 16));

        print(fourNumberSum1(arr, 16));
    }

    private static void print(List<Integer[]> fn) {
        for (Integer[] sum : fn) {
            System.out.println(Arrays.toString(sum));
        }
    }
}

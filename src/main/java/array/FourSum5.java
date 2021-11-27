package array;

import java.util.*;

public class FourSum5 {

    // O(n ^ 4) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();
        if (arr == null || arr.length < 4) return res;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int z = k + 1; z < arr.length; z++) {
                        if (arr[i] + arr[j] + arr[k] + arr[z] == target) {
                            res.add(new Integer[] {arr[i], arr[j], arr[k], arr[z]});
                        }
                    }
                }
            }
        }

        return res;
    }

    // Worst: O(n ^ 3) time | O(n ^ 2) space
    // Avg: O(n ^ 2) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum1(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();
        if (arr == null || arr.length < 4) return res;

        Map<Integer, List<Integer[]>> numbers = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (numbers.containsKey(sum)) {
                    for (Integer[] pair : numbers.get(sum)) {
                        res.add(new Integer[] {arr[i], arr[j], pair[0], pair[1]});
                    }
                }
            }

            for (int k = i - 1; k >= 0; k--) {
                int compensateKey = target - arr[i] - arr[k];
                List<Integer[]> lst = numbers.getOrDefault(compensateKey, new ArrayList<>());
                lst.add(new Integer[] {arr[i], arr[k]});
                numbers.put(compensateKey, lst);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {7, 6, 4, -1, 1, 2};

        print(fourNumberSum(arr, 16));
        System.out.println("=======================");
        print(fourNumberSum1(arr, 16));
    }

    private static void print(List<Integer[]> fn) {
        for (Integer[] sum : fn) {
            System.out.println(Arrays.toString(sum));
        }
    }
}

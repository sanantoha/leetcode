package array;

import java.util.*;

public class FourSum4 {

    // O(n ^ 4) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();
        if (arr == null || arr.length < 4) return res;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int z = j + 1; z < arr.length; z++) {
                    for (int k = z + 1; k < arr.length; k++) {
                        if (arr[i] + arr[j] + arr[z] + arr[k] == target) {
                            res.add(new Integer[] {arr[i], arr[j], arr[z], arr[k]});
                        }
                    }
                }
            }
        }
        return res;
    }

    // Avg: O(n ^ 2) time | O(n ^ 2) space
    // Worst: O(n ^ 3) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum1(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();
        if (arr == null || arr.length < 4) return res;

        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {

            for (int k = i + 1; k < arr.length; k++) {
                int compensate = target - arr[i] - arr[k];
                List<Integer[]> lst = map.get(compensate);
                if (lst != null) {
                    for (Integer[] pair : lst) {
                        res.add(new Integer[] {arr[i], arr[k], pair[0], pair[1]});
                    }
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                int key = arr[i] + arr[j];
                List<Integer[]> lst = map.getOrDefault(key, new ArrayList<>());
                lst.add(new Integer[] {arr[i], arr[j]});
                map.put(key, lst);
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

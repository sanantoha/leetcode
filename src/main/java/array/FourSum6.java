package array;

import java.util.*;

public class FourSum6 {

    // O(n ^ 4) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return Collections.emptyList();
        List<Integer[]> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int z = j + 1; z < arr.length; z++) {
                    for (int k = z + 1; k < arr.length; k++) {
                        if (target == arr[i] + arr[j] + arr[z] + arr[k]) {
                            res.add(new Integer[] {arr[i], arr[j], arr[z], arr[k]});
                        }
                    }
                }
            }
        }

        return res;
    }

    // Worst O(n ^ 3) time | O(n ^ 2) space
    // Avg O(n ^ 2) time | O(n ^ 2) space
    public static List<Integer[]> fourNumberSum1(int[] arr, int target) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<Integer[]> res = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int compensate = target - arr[i] - arr[j];
                if (map.containsKey(compensate)) {
                    for (Integer[] pair : map.get(compensate)) {
                        res.add(new Integer[] {arr[i], arr[j], pair[0], pair[1]});
                    }
                }
            }

            for (int j = i - 1; j >= 0; j--) {
                int key = arr[i] + arr[j];
                List<Integer[]> lst = map.getOrDefault(key, new ArrayList<>());
                lst.add(new Integer[] { arr[i], arr[j] });
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

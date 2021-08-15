package array;

import java.util.*;

public class FourSum1 {

    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();
        if (arr == null || arr.length < 4) return res;


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int z = k + 1; z < arr.length; z++) {
                        int sum = arr[i] + arr[j] + arr[k] + arr[z];
                        if (sum == target) {
                            res.add(new Integer[] {arr[i], arr[j], arr[k], arr[z]});
                        }
                    }
                }
            }
        }
        return res;
    }

    public static List<Integer[]> fourNumberSum1(int[] arr, int target) {
        List<Integer[]> res = new ArrayList<>();

        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int compensate = target - arr[i] - arr[j];
                List<Integer[]> lst = map.get(compensate);
                if (lst != null) {
                    for (Integer[] pair : lst) {
                        res.add(new Integer[] {arr[i], arr[j], pair[0], pair[1]});
                    }
                }
            }

            for (int k = i - 1; k >= 0; k--) {
                int sum = arr[i] + arr[k];
                List<Integer[]> lst = map.getOrDefault(sum, new ArrayList<>());
                lst.add(new Integer[] {arr[i], arr[k]});
                map.put(sum, lst);
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

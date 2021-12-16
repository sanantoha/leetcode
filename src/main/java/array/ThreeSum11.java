package array;

import java.util.Arrays;
import java.util.List;

public class ThreeSum11 {
    public static List<Integer[]> threeNumberSum(int[] arr, int target) {
        return null;
    }

    public static List<Integer[]> threeNumberSum1(int[] arr, int target) {
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};

        List<Integer[]> res = threeNumberSum(arr, 0);
        res.forEach(xs -> System.out.println(Arrays.toString(xs)));

        System.out.println("=======================");

        List<Integer[]> res1 = threeNumberSum1(arr, 0);
        res1.forEach(xs -> System.out.println(Arrays.toString(xs)));
    }
}

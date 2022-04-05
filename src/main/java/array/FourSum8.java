package array;

import java.util.Arrays;
import java.util.List;

public class FourSum8 {

    public static List<Integer[]> fourNumberSum(int[] arr, int target) {
        return null;
    }

    public static List<Integer[]> fourNumberSum1(int[] arr, int target) {
        return null;
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

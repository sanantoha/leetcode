package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum5 {

    public static List<Integer[]> threeNumberSum(int[] arr, int target) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<Integer[]> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        res.add(new Integer[] {arr[i], arr[j], arr[k]});
                    }
                }
            }
        }

        return res;
    }

    public static List<Integer[]> threeNumberSum1(int[] arr, int target) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<Integer[]> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) continue;

            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = arr[l] + arr[i] + arr[r];
                if (sum == target) {
                    res.add(new Integer[] {arr[l], arr[i], arr[r]});
                    while (l < r && arr[l] == arr[l + 1]) l++;
                    while (l < r && arr[r - 1] == arr[r]) r--;
                    l++;
                    r--;
                } else if (sum < target) l++;
                else r--;
            }
        }

        return res;
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

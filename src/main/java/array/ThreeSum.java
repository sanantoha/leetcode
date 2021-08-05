package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int curr = arr[i];
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[l] + arr[r] + curr;
                if (sum == 0) {
                    res.add(Arrays.asList(curr, arr[l], arr[r]));
                    while (l < r && arr[l] == arr[l + 1]) l++;
                    while (l < r && arr[r] == arr[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(arr));
    }
}

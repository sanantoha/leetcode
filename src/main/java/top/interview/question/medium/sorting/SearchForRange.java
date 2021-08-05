package top.interview.question.medium.sorting;

import java.util.Arrays;

class Solution4 {

    public int[] searchRange0(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                int l = mid;
                int r = mid;
                while (l >= 0 && nums[mid] == nums[l]) l--;
                while (r <= hi && nums[mid] == nums[r]) r++;
                return new int[] {l + 1, r - 1};
            }
        }
        return new int[] {-1, -1};
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int lo = leftSearch(nums, target);
        if (lo == -1) return new int[] {-1, -1};
        int hi = rightSearch(nums, lo, target);
        return new int[] {lo, hi};
    }


    public int leftSearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return (nums[lo] == target) ? lo : -1;
    }

    public int rightSearch(int[] nums, int lo, int target) {
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2 + 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return hi;
    }
}

public class SearchForRange {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(s.searchRange(arr, 8)));

        System.out.println(Arrays.toString(s.searchRange(arr, 6)));

        int[] arr1 = {1};

        System.out.println(Arrays.toString(s.searchRange(arr1, 1)));

        int[] arr2 = {};

        System.out.println(Arrays.toString(s.searchRange(arr2, 0)));
    }
}

package top.interview.question.medium.sorting;

class Solution6 {

    public int findSmallIndex(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    public int search0(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int smallInd = findSmallIndex(nums);

        int lo = 0;
        int hi = nums.length - 1;

        if (target >= nums[smallInd] && target <= nums[hi]) {
            lo = smallInd;
        } else {
            hi = smallInd - 1;
        }

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == target) return mid;

            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int searchRec(int[] nums, int lo, int hi, int target) {
        if (nums == null || nums.length == 0) return -1;

        if (lo > hi) return -1;

        int mid = (lo + hi) >>> 1;

        if (nums[mid] == target) return mid;

        if (nums[lo] <= nums[mid]) {
            if (target >= nums[lo] && target <= nums[mid]) {
                return searchRec(nums, lo, mid - 1, target);
            }
            return searchRec(nums, mid + 1, hi, target);
        }

        if (target >= nums[mid] && target <= nums[hi]) {
            return searchRec(nums, mid + 1, hi, target);
        }

        return searchRec(nums, lo, mid - 1, target);
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (target >= nums[mid] && target <= nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }
        return -1;
    }
}

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution6 s = new Solution6();

        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(s.search(arr, 0));
        System.out.println(s.searchRec(arr, 0, arr.length - 1, 0));
        System.out.println(s.search0(arr, 0));

        int[] arr1 = {5,1,3};
        System.out.println(s.search(arr1, 5));
        System.out.println(s.searchRec(arr1, 0, arr1.length - 1, 5));
        System.out.println(s.search0(arr1, 5));
    }
}

package top.interview.question.easy.array;

import java.util.Arrays;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

class Solution3 {

    public boolean containsDuplicate0(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.containsDuplicate(new int[] {1,2,3,1}));


        System.out.println(s.containsDuplicate(new int[] {1,2,3,4}));

        System.out.println(s.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}

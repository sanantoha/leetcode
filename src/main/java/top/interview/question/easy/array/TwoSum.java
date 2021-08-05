package top.interview.question.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution8 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && target - nums[i] - nums[j] == 0) {
                    res[0] = j;
                    res[1] = i;
                }
            }
        }
        return res;
    }

    public int[] twoSum0(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer j = mp.get(target - nums[i]);
            if (j != null && i != j) {
                return new int[] {i, j};
            }
        }
        return new int[0];
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution8 s = new Solution8();

//        int[] nums = {2,7,11,15};
        int[] nums = {3,2,4};

        System.out.println(Arrays.toString(s.twoSum0(nums, 6)));
    }
}

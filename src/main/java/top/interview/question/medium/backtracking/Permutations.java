package top.interview.question.medium.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution2 {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<Integer> createList(int[] nums) {
        List<Integer> lst = new ArrayList<>(nums.length);
        for (int v : nums) {
            lst.add(v);
        }
        return lst;
    }

    public List<List<Integer>> permute0(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        permute(nums, nums.length, res);

        return res;
    }

    public void permute(int[] nums, int n, List<List<Integer>> res) {
        if (n == 0) {
            return;
        } else if (n == 1) {
            res.add(createList(nums));
        } else {
            for(int i = 0; i < n-1; i++) {
                permute(nums, n - 1, res);
                if(n % 2 == 0) {
                    swap(nums, i, n-1);
                } else {
                    swap(nums, 0, n-1);
                }
            }
            permute(nums, n - 1, res);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }

        int[] indexes = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            if (indexes[i] < i) {
                swap(nums, i % 2 == 0 ? 0 : indexes[i], i);
                res.add(createList(nums));
                indexes[i]++;
                i++;
            } else {
                indexes[i] = 0;
                res.add(createList(nums));
                i++;
            }
        }

        return res;
    }
}

public class Permutations {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.permute(new int[]{1,2,3}));

        System.out.println(s.permute(new int[]{1}));

        System.out.println(s.permute(new int[]{}));


    }
}

package top.interview.question.medium.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution3 {
    public List<List<Integer>> subsets0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());


        for (int i = 0; i < nums.length; i++) {
            while (queue.peek().size() == i - 1) {
                List<Integer> lst = queue.remove();
                for (int j = 0; j < nums.length; j++) {
                    if (lst.isEmpty() || lst.get(lst.size() - 1) < nums[j]) {
                        List<Integer> l = new ArrayList<>(lst);
                        l.add(nums[j]);
                        result.add(l);
                        queue.add(l);
                    }
                }

            }
        }

        List<Integer> last = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            last.add(nums[i]);
        }
        result.add(last);

        return result;
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }

}

public class Subsets {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.subsets(new int[]{1,2, 3}));

        System.out.println(s.subsets(new int[]{0}));
    }
}

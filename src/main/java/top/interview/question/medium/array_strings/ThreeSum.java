package top.interview.question.medium.array_strings;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution0 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i < j && j < k && nums[k] == -nums[i] - nums[j]) {
                        int x = nums[i];
                        int y = nums[j];
                        int z = nums[k];
                        int min = Math.min(Math.min(x, y), z);
                        int max = Math.max(Math.max(x, y), z);
                        set.add(Arrays.asList(min, - min - max, max));
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    public List<List<Integer>> threeSum0(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int v = -nums[i] - nums[j];
                if (map.containsKey(v) && i < j && j < map.get(v)) {
                    int k = map.get(v);
                    int x = nums[i];
                    int y = nums[j];
                    int z = nums[k];
                    int min = Math.min(Math.min(x, y), z);
                    int max = Math.max(Math.max(x, y), z);
                    set.add(Arrays.asList(min, - min - max, max));
                }
            }
        }

        return new ArrayList<>(set);
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        int[] arr = {-1,0,1,2,-1,-4};

//        int[] arr = {0};

        System.out.println(s.threeSum0(arr));
    }
}

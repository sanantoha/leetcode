package easy;

import java.util.HashMap;
import java.util.Map;

class Solution0 {
    public int sumOfUnique(int[] nums) {
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else map.put(nums[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }

    public int sumOfUnique0(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (map.keySet().contains(val)) {
                if (map.get(val) == 1) {
                    sum -= val;
                }
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
                sum += val;
            }
        }

        return sum;
    }
}

public class SumOfUniqueElements {
    public static void main(String[] args) {
        Solution0 s = new Solution0();

        System.out.println(s.sumOfUnique(new int[] {1,2,3,2}));
        System.out.println(s.sumOfUnique0(new int[] {1,2,3,2}));

        System.out.println("=====================================");

        System.out.println(s.sumOfUnique(new int[] {1,1,1,1}));
        System.out.println(s.sumOfUnique0(new int[] {1,1,1,1}));

        System.out.println("=====================================");

        System.out.println(s.sumOfUnique(new int[] {1,2,3,4,5}));
        System.out.println(s.sumOfUnique0(new int[] {1,2,3,4,5}));
    }
}

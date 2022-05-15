package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // O(n) time | O(n) space
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    /**
     * https://leetcode.com/explore/interview/card/apple/344/array-and-strings/3115/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1,1,1}, 2)); // 2

        System.out.println(subarraySum(new int[] {1, 2, 3}, 3)); // 2
    }
}

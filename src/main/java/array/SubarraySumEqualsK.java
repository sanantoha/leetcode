package array;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        return -1;
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

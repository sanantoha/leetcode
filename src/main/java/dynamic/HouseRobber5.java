package dynamic;

public class HouseRobber5 {

    // O(n) time | O(n) space
    public static int rob(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int[] items = new int[arr.length];
        items[0] = arr[0];
        items[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            items[i] = Math.max(items[i - 1], items[i - 2] + arr[i]);
        }
        return items[items.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,7,5,3,1}; // 14

        System.out.println(rob(nums));
    }
}

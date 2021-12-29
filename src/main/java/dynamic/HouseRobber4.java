package dynamic;

public class HouseRobber4 {

    // O(n) time | O(n) space
    public static int rob(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int[] profits = new int[arr.length];
        profits[0] = arr[0];
        profits[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            profits[i] = Math.max(profits[i - 2] + arr[i], profits[i - 1]);
        }
        return profits[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,7,5,3,1}; // 14

        System.out.println(rob(nums));
    }
}

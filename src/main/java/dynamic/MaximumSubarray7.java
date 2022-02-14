package dynamic;

public class MaximumSubarray7 {

    // O(n) time | O(1) space
    public static int maximumSubarray0(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int maximum = 0;
        int sum = 0;

        for (int num : arr) {
            sum += num;
            if (maximum < sum) {
                maximum = sum;
            }
            if (sum < 0) sum = 0;
        }
        return maximum;
    }

    // O(n) time | O(1) space
    public static int maximumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int maximum = arr[0];
        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            maximum = Math.max(maximum, sum);
        }
        return maximum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4}; // 19
        System.out.println(maximumSubarray(arr));

        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4}; // 6

        System.out.println(maximumSubarray(arr1));

        int[] arr2 = {3, 4, -6, 7, 8, -18, 100}; // 100
        System.out.println(maximumSubarray(arr2));
    }
}

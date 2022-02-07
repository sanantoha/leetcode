package array;

public class FirstDuplicateValue4 {

    // O(n) time | O(1) space
    public static int firstDuplicateValue(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        for (int num : arr) {
            int absVal = Math.abs(num);
            if (arr[absVal - 1] < 0) return absVal;
            arr[absVal - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,2,7,8,9};
        System.out.println(firstDuplicateValue(arr));
        System.out.println(firstDuplicateValue(new int[0]));
    }
}

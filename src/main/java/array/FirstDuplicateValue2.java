package array;

import java.util.Arrays;

public class FirstDuplicateValue2 {

    public static int firstDuplicateValue(int[] arr) {

        for (int val : arr) {
            int absVal = Math.abs(val);
            if (arr[absVal - 1] < 0) return absVal;
            arr[absVal - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,2,7,8,9};
        System.out.println(firstDuplicateValue(arr));
    }
}

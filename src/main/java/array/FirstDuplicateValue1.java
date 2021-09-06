package array;

/**
 * given array of integers between 1 and n, inclusive where n is the length of the array.
 * find first duplicate and return value;
 */
public class FirstDuplicateValue1 {

    public static int firstDuplicateValue(int[] array) {
        if (array == null || array.length == 0) return -1;

        for (int val : array) {
            int absVal = Math.abs(val);
            if (array[absVal - 1] < 0) return absVal;
            array[absVal - 1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,2,7,8,9};
        System.out.println(firstDuplicateValue(arr));
    }
}

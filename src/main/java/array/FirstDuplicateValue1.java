package array;

/**
 * given array of integers between 1 and n, inclusive where n is the length of the array.
 * find first duplicate and return value;
 */
public class FirstDuplicateValue1 {

    public static int firstDuplicateValue(int[] arr) {
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,3,4,5,6,2,7,8,9};
        System.out.println(firstDuplicateValue(arr));
        System.out.println(firstDuplicateValue(new int[0]));
    }
}
